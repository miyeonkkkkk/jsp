package kr.or.ddit.yogurt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import kr.or.ddit.yogurt.model.CycleVO;
import kr.or.ddit.yogurt.model.DailyVO;

public class YogurtProcessor implements ItemProcessor<CycleVO, List<DailyVO>> {
	
	private static final Logger logger = LoggerFactory.getLogger(YogurtProcessor.class);

	// jobLauncher 를 실행하면서 두번째 인자로 넣어준 javParameter 값을 SPEL을 통해 주입
	// 단, jobParmters에 접근하기 위해서는 해당 스프링 빈의 scope를 step으로 지정해야 한다.
	@Value("#{jobParameters[ym]}")
	private String ym;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public List<DailyVO> process(CycleVO item) throws Exception {
		// 생성 월이 2020년 11월
		// cid=1, pid=100, day=2, cnt=3
		// ===>
		// cid=1, pid=100, dt=20201102, cnt=3
		// cid=1, pid=100, dt=20201109, cnt=3
		// cid=1, pid=100, dt=20201116, cnt=3
		// cid=1, pid=100, dt=20201123, cnt=3
		// cid=1, pid=100, dt=20201130, cnt=3
		
		logger.debug("ym : {}, item : {}", ym, item);
		
		List<DailyVO> dailyList = new ArrayList<DailyVO>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0, 4))); // 2020
		calendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4))-1); // 11
		
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // 해당월의 마지막 날짜로 설정
		
		// calendar 2020 11 30
		Date endTime = calendar.getTime();
//		endTime.setDate(endTime.getDate() + 1);
		String endTimeStr = sdf.format(endTime);
		
		int endTimeInt = Integer.parseInt(endTimeStr) + 1;
		
		// 해당 월의 1일로 설정
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date dt = calendar.getTime();
		String sdt = sdf.format(dt);
		int dtInt = Integer.parseInt(sdt);
		// calendar 2020 11 01
		
		
		// calendar 날짜가 item의 애음요일과 같을 때만 dailyVO 를 생성
//		while (endTime.after(calendar.getTime())) {
		while (endTime.compareTo(calendar.getTime()) > -1) {
//		while (endTimeInt > dtInt) {
			if(item.getDay() == calendar.get(calendar.DAY_OF_WEEK)) {
				DailyVO dailyVo = new DailyVO();
				dailyVo.setCid(item.getCid());
				dailyVo.setPid(item.getPid());
				dailyVo.setDt(sdf.format(calendar.getTime()));
				dailyVo.setCnt(item.getCnt());
				
				dailyList.add(dailyVo);
			}
			
			// 날짜를 하루씩 증가
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
//			dt = calendar.getTime();
//			sdt = sdf.format(dt);
//			dtInt = Integer.parseInt(sdt);
		}
		
		return dailyList;
	}

}
