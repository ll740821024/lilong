package org.lilong.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		ArrayList<CoordinateModel> sample = new ArrayList<CoordinateModel>();
		String pathname  = "F:\\ThoughtWorks\\test.txt";
		File file = new File(pathname);
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			int count = 0;
			while((line = br.readLine()) != null){
				String[] ss = line.split(" ");
				CoordinateModel coordinateModel = new CoordinateModel();
				coordinateModel.setName(ss[0]);
				coordinateModel.setId(count++);
				coordinateModel.setX(Integer.parseInt(ss[1]));
				coordinateModel.setY(Integer.parseInt(ss[2]));
				coordinateModel.setZ(Integer.parseInt(ss[3]));
				if(ss.length == 7){
					coordinateModel.setOffsetX(Integer.parseInt(ss[4]));
					coordinateModel.setOffsetY(Integer.parseInt(ss[5]));
					coordinateModel.setOffsetZ(Integer.parseInt(ss[6]));
				}
				sample.add(coordinateModel);
			}
			
			String res = calCoordinateStatus(num,sample);
			System.out.println(res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String calCoordinateStatus(int num, ArrayList<CoordinateModel> sample) {
		int listSize = sample.size();
		if(num == 0) return sample.get(0).getName()+" 0 1 1 1";
		if(num >= listSize) return "Cannot find " + num;
		for(int i=1; i<listSize; i++){
			int id = sample.get(i).getId();
			int beforeX = sample.get(i-1).getX();
			int beforeY = sample.get(i-1).getX();
			int beforeZ = sample.get(i-1).getX();
			int beforeoffsetX = sample.get(i-1).getOffsetX();
			int beforeoffsetY = sample.get(i-1).getOffsetY();
			int beforeoffsetZ = sample.get(i-1).getOffsetZ();
			int X = sample.get(i).getX();
			int Y = sample.get(i).getY();
			int Z = sample.get(i).getZ();
			int offsetX = sample.get(i).getOffsetX();
			int offsetY = sample.get(i).getOffsetY();
			int offsetZ = sample.get(i).getOffsetZ();
			if(num == id){
				if(offsetX==Integer.MAX_VALUE || offsetY==Integer.MAX_VALUE || offsetZ==Integer.MAX_VALUE){
					return "error: "+id;
				}
				if(num==1 && X==1 && Y==1 && Z==1){
					return sample.get(i).getName()+" "+id+" "+(X+offsetX)+" "+(Y+offsetY)+" "+(Z+offsetZ); 
				}else if(((beforeX+beforeoffsetX)==X) && ((beforeY+beforeoffsetY)==Y) && ((beforeZ+beforeoffsetZ)==Z)){
					return sample.get(i).getName()+" "+id+" "+(X+offsetX)+" "+(Y+offsetY)+" "+(Z+offsetZ);
				}else{
					return "error: "+id;
				}
			}
			
		}		
		return "";
	}
}
