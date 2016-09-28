package Pocket_Gem_OA;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogParser {
	// variables to store the time with specific state
	private static long start, end, mytime, connect, disconnect, curtime,
			total, online;

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
//		String filename = "input_1.txt";
//		String filename = "input_2.txt";
		String filename = "input_2.txt";
		if (args.length > 0) {
			filename = args[0];
		}

		String answer = parseFile(filename);
		System.out.println(answer);
	}

	static String parseFile(String filename) throws FileNotFoundException,
			IOException {
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines.toArray(new String[allLines.size()]));
	}

	static String parseLines(String[] lines) {
		/*
		 * 
		 * Your code goes here
		 */
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
		Date myDate;
		boolean on = false;
		String time, state;
		int index;
		for (String line : lines) {
			try {
				index = line.lastIndexOf("::");
				// if the input line is invalid, ingore the line
				if (index == -1) {
					continue;
				}
				time = line.substring(1, index - 2);
				state = line.substring(index + 2).trim();
				myDate = df.parse(time);
				curtime = myDate.getTime();
				if (state.equals("START")) {
					start = curtime;
				} else if (state.equals("SHUTDOWN")) {
					end = curtime;
					total = end - start;
				} else if (state.equals("CONNECTED")) {
					if (on) {
						continue;
					} else {
						on = true;
						connect = curtime;
					}
				} else if (state.equals("DISCONNECTED")) {
					if (!on) {
						continue;
					} else {
						on = false;
						disconnect = curtime;
						online += disconnect - connect;
					}
				}
			}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// check if it is still connected
		if (on) {
			online += end - connect;
			on = false;
		}
		
		// after that need to calculate the connectivity percentage
		if (total == 0) {
			return new String("0%");
		}
		int perc =  (int)(online * 100 / total);
		StringBuilder sb = new StringBuilder();
		sb.append(perc);
		sb.append('%');
		return sb.toString();
		
	}
}
