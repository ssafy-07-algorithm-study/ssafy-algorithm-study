import java.util.*;

public class 프로그래머스_2022Kakao_주차요금계산 {
	public static void main(String[] args) {
		int[] fees = { 1, 10, 1, 11 };
		String[] records = { "00:00 1234 IN", "00:02 1234 OUT" };

		solution(fees, records);

	}

	static class Record implements Comparable<Record> {
		int hour, minute;
		int carNum;
		String status;

		public Record(int hour, int minute, int carNum, String status) {
			super();
			this.hour = hour;
			this.minute = minute;
			this.carNum = carNum;
			this.status = status;
		}

		@Override
		public int compareTo(Record o) {
			return this.carNum - o.carNum;
		}
	}

	private static int[] solution(int[] fees, String[] records) {
		Record[] record = new Record[records.length];

		StringTokenizer st = null;
		int idx = 0;
		for (String str : records) {
			st = new StringTokenizer(str, " ");
			String time = st.nextToken();
			StringTokenizer stTime = new StringTokenizer(time, ":");

			record[idx++] = new Record(Integer.parseInt(stTime.nextToken()), Integer.parseInt(stTime.nextToken()),
					Integer.parseInt(st.nextToken()), st.nextToken());
		}

		// 차량번호별 정렬
		Arrays.sort(record);

		int prevCarNum = record[0].carNum;
		int curCarNum;
		String prevStatus = "";
		int inHour, inMinute, outHour, outMinute;
		inHour = inMinute = outHour = outMinute = 0;
		int timeSum = 0;
		double price = 0;

		List<Double> prices = new LinkedList<Double>();

		for (int i = 0; i < record.length; i++) {
			curCarNum = record[i].carNum;

			if (i == record.length - 1) {
				// 마지막이면 요금 계산
				if (prevCarNum == curCarNum) {
					if (record[i].status.equals("IN")) {
						timeSum += (23 - record[i].hour) * 60 + (59 - record[i].minute);
					} else {
						// 시간 계산
						if (record[i].minute >= inMinute) {
							timeSum += (record[i].hour - inHour) * 60 + (record[i].minute - inMinute);
						} else {
							timeSum += (record[i].hour - inHour - 1) * 60 + (60 - (inMinute - record[i].minute));
						}
					}
					// 요금 계산
					if (timeSum <= fees[0]) { // 기본시간동안만 주차한 경우
						price = fees[1];
					} else { // 기본시간 초과해서 주차한 경우
						price = fees[1] + (Math.ceil((double) (timeSum - fees[0]) / (double) fees[2])) * fees[3];
					}
					prices.add(price);
				} else {
					if (prevStatus.equals("IN")) {
						timeSum += (23 - inHour) * 60 + (59 - inMinute);
					}
					// 요금 계산
					if (timeSum <= fees[0]) { // 기본시간동안만 주차한 경우
						price = fees[1];
					} else { // 기본시간 초과해서 주차한 경우
						price = fees[1] + (Math.ceil((double) (timeSum - fees[0]) / (double) fees[2])) * fees[3];
					}
					prices.add(price);
					if (record[i].status.equals("IN")) {
						timeSum = (23 - record[i].hour) * 60 + (59 - record[i].minute);
					}
					// 요금 계산
					if (timeSum <= fees[0]) { // 기본시간동안만 주차한 경우
						price = fees[1];
					} else { // 기본시간 초과해서 주차한 경우
						price = fees[1] + (Math.ceil((double) (timeSum - fees[0]) / (double) fees[2])) * fees[3];
					}
					prices.add(price);
				}
				break;
			}

			if (record[i].status.equals("IN")) {
				if (prevCarNum == curCarNum) {
					inHour = record[i].hour;
					inMinute = record[i].minute;
					prevStatus = "IN";
					prevCarNum = record[i].carNum;
				} else {
					if (prevStatus.equals("IN")) {
						timeSum += (23 - inHour) * 60 + (59 - inMinute);
					}
					// 요금 계산
					if (timeSum <= fees[0]) { // 기본시간동안만 주차한 경우
						price = fees[1];
					} else { // 기본시간 초과해서 주차한 경우
						price = fees[1] + (Math.ceil((double) (timeSum - fees[0]) / (double) fees[2])) * fees[3];
					}
					prices.add(price);
					timeSum = 0;
					inHour = record[i].hour;
					inMinute = record[i].minute;
					prevStatus = "IN";
					prevCarNum = record[i].carNum;
				}
			} else {
				outHour = record[i].hour;
				outMinute = record[i].minute;

				// 시간 계산
				if (outMinute >= inMinute) {
					timeSum += (outHour - inHour) * 60 + (outMinute - inMinute);
				} else {
					timeSum += (outHour - inHour - 1) * 60 + (60 - (inMinute - outMinute));
				}

				prevCarNum = record[i].carNum;
				prevStatus = "OUT";
			}
		}

		int answer[] = new int[prices.size()];
		idx = 0;
		for (double p : prices) {
			answer[idx++] = (int) p;
		}
		return answer;
	}
}
