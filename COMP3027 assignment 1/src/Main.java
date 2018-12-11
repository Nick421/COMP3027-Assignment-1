import java.util.*;

class Main
{
	public static void main(String[] args)
	{
		// this code reads the input data into a couple of lists
		Scanner reader = new Scanner(System.in);
		double T = reader.nextDouble();
		int n = reader.nextInt();
		TreeMap<Double, ArrayList<Double>> timi = new TreeMap<Double, ArrayList<Double>>();
		
		
		double totalTime = 0.0;
		double mfinal = 0;
		double timeRemain = T;
		for(int i = 1; i <= n; ++i)
		{
			double t = reader.nextDouble();
			double m = reader.nextDouble();
			totalTime += t;
			timeRemain -= t/2;
			mfinal += m/2;
			ArrayList<Double> tmlist = new ArrayList<Double>(2);
			
			tmlist.add(t/2);
			tmlist.add(m/2);
			double quotient = t/m;
			if (timi.containsKey(quotient)){
				tmlist.set(0, timi.get(quotient).get(0)+t/2);
				tmlist.set(1, timi.get(quotient).get(1)+m/2);
			}
			timi.put((t/m), tmlist);
			
			
		}
		reader.close();
		
		// you will want to put the data in a different data structure
		// (you don't need anything fancy, but two separate lists might
		// be a little bit awkward)
		
		
		double answer = 0.0;
		
		if (totalTime > 2*T ){
			System.out.println(answer);
			return;
		}
		
		
		
		for (ArrayList<Double> d : timi.values()){
			double progress = (timeRemain/d.get(0));
			
			if (progress >=1){
				progress = 1.0;
				answer += d.get(1);
				timeRemain = timeRemain-(progress*d.get(0));
			}else {
				answer += d.get(1)*progress;
				timeRemain = timeRemain-(progress*d.get(0));
			}
			
		}
		answer+=mfinal;

		// output a single number representing the solution
		// (your program should not output any other text)
		System.out.println(answer);
	}
	
}
