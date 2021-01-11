package Question4;

import java.util.List;

public class BagApp {
	
	public static double calcTotalVolume(List<Bag> bagList, double accum) {

		if(bagList != null && bagList.size() > 0) {//check if the bagList got something
			accum += bagList.get(0).getVolume(); //get first element's volume from bagList to the accum
			List<Bag> subBagList = bagList.subList(1, bagList.size());//create sub list to get bagList's first index to the last index data
			return calcTotalVolume(subBagList, accum); //return sub list and accum
		}
		else 
			return accum;
	}
}//end of class BagApp
