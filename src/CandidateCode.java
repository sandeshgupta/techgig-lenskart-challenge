/* Read input from STDIN. Print your output to STDOUT*/
//https://www.techgig.com/challenge/question/coding-test/OThNRGRzb21mQkQ5NGhQcEVHY0hwQURReDA1ZitlMitzMTRaMXVMRTlCdz0=/1

import java.io.*;

public class CandidateCode {

	public static void main(String args[]) throws Exception {

		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		int blue, red, green, yellow;
		int length = 0;

		blue = Integer.parseInt(buff.readLine());
		red = Integer.parseInt(buff.readLine());
		yellow = Integer.parseInt(buff.readLine());
		green = Integer.parseInt(buff.readLine());

		if (red > 0 && blue > 0 && yellow == 0 && green == 0) {
			length += Math.max(blue + 1, red);
		} else if (blue > 0) {
			length += blue; // b

			if (yellow > 0) {
				length += calcMaxPoss(red, yellow); // b+min(r,y)
			} else {
				length++; // b+1
			}

			if (green > 0) {
				length += green; // b+g+min(r,y) || b+g+1
			}
		} else if (green > 0) {
			length += green; // g
			if (red > 0 && yellow > 0) {
				length += calcMaxPoss(red, yellow); // g+min(r,y)
			} else if ((red > 0 && yellow == 0) || (red == 0 && yellow > 0)) {
				length++; // g+1
			}
		} else {
			if (red > 0 && yellow > 0) {
				length += calcMaxPoss(red, yellow); // min(r,y)
			} else if ((red > 0 && yellow == 0) || (red == 0 && yellow > 0)) {
				length++; // 1
			}
		}

		System.out.println(length);

	}

	public static int calcMaxPoss(int red, int yellow) {
		if (red <= yellow) {
			return 2 * Math.min(red, yellow);
		} else
			return 2 * Math.min(red, yellow) + 1;
	}

}