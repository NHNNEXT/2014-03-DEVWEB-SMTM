package work;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.WorkDao;
import entity.Usr;
import entity.Work;

public class ShowWorkListBiz {
	Map<String, List<Work>> workMap = new HashMap<String, List<Work>>();
	Map<String, Long> confirmedMoneyMap = new HashMap<String, Long>();
	Map<String, Long> totalMoneyMap = new HashMap<String, Long>();
	int wage = 5580;

	public Map<String, List<Work>> selectWorkForAlba(Usr usr) {
		WorkDao dao = new WorkDao();
		List<Work> worklist = dao.selectWorkForAlba(usr);
		for (Work work : worklist) {
			inputWork(work.getName(), work);
		}
		return workMap;
	}

	public Map<String, List<Work>> selectWorkForManager(String storeSeq) {
		WorkDao dao = new WorkDao();
		List<Work> worklist = dao.selectWorkForManager(storeSeq);
		for (Work work : worklist) {
			inputWork(work.getName(), work);
		}
		return workMap;
	}

	private void inputWork(String key, Work work) {
		List<Work> workList = new ArrayList<Work>();
		if (workMap.containsKey(key)) {
			workList = workMap.get(key);
			workMap.remove(key);
		}
		workList.add(work);
		workMap.put(key, workList);
	}

	public Map<String, Long> calculateConfirmedMoney() throws ParseException {
		for (String key : workMap.keySet()) {
			confirmedMoneyMap.put(key, valueOfConfirmedMoney(workMap.get(key)));
		}
//		System.out.println("confirm " + confirmedMoneyMap.toString());
		return confirmedMoneyMap;

	}

	private Long valueOfConfirmedMoney(List<Work> list) throws ParseException {
		long result = 0;
		for (Work work : list) {
			if (work.getStus().equals("1004"))
				result += Math.round(work.getTime() / 3600) * wage;
		}
		return result;

	}

	public Map<String, Long> calculateTotalMoney() throws ParseException {
		for (String key : workMap.keySet()) {
			totalMoneyMap.put(key, valueOfTotalMoney(workMap.get(key)));
		}
		return totalMoneyMap;
	}

	private Long valueOfTotalMoney(List<Work> list) throws ParseException {
		long result = 0;
		for (Work work : list) {
			result += Math.round(work.getTime() / 3600) * wage;
		}
		return result;
	}

}
