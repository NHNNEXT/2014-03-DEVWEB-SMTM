package work;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.WorkDao;
import entity.User;
import entity.Work;

public class ShowWorkListBiz {
	Map<String, List<Work>> workMap = new HashMap<String, List<Work>>();
	Map<String, Long> confirmedMoneyMap = new HashMap<String, Long>();
	Map<String, Long> totalMoneyMap = new HashMap<String, Long>();
	int wage = 5580;

	public Map<String, List<Work>> selectWork(User usr, String storeSeq) {
		WorkDao dao = new WorkDao();
		List<Work> workList;
		if (storeSeq == null)
			workList = dao.selectWorkForAlba(usr);
		else
			workList = dao.selectWorkForManager(storeSeq);

		for (Work work : workList)
			inputWork(work.getName(), work);

		return workMap;
	}

	private void inputWork(String key, Work work) {
		List<Work> workList = new ArrayList<Work>();
		if (workMap.containsKey(key)) {
			workList = workMap.get(key);
		}
		workList.add(work);
		workMap.put(key, workList);
	}

	public void calculate() throws ParseException {
		for (String key : workMap.keySet()) {
			confirmedMoneyMap.put(key, valueOfConfirmedMoney(workMap.get(key)));
			totalMoneyMap.put(key, valueOfTotalMoney(workMap.get(key)));
		}
	}

	private Long valueOfConfirmedMoney(List<Work> list) throws ParseException {
		long result = 0;
		for (Work work : list) {
			if (work.getStatus().equals("1004"))
				result += Math.round(work.getTime() / 3600) * wage;
		}
		return result;
		
	}
	
	private Long valueOfTotalMoney(List<Work> list) throws ParseException {
		long result = 0;
		for (Work work : list) {
			result += Math.round(work.getTime() / 3600) * wage;
		}
		return result;
	}
	
	public Map<String, Long> getConfirmedMoneyMap() {
		return confirmedMoneyMap;
	}

	public Map<String, Long> getTotalMoneyMap() {
		return totalMoneyMap;
	}
	
	

}
