/*
 * Copyright 2007 Future Earth, info@future-earth.eu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.Date;


public class GregorianCalendar extends Calendar implements Cloneable {

	private Date date = new Date();

	public GregorianCalendar() {
		super();
	}

	public Object clone() {
		final GregorianCalendar date = new GregorianCalendar();
		date.setTime(getTime());
		return date;
	}

	public void setTimeInMillis(long millis) {
		date.setTime(millis);
	}

	public long getTimeInMillis() {
		return date.getTime();
	}

	public int get(int field) {
		switch (field) {
		case HOUR: {
			return date.getHours();
		}
		case HOUR_OF_DAY: {
			return date.getHours();
		}

		case MINUTE: {
			return date.getMinutes();
		}
		case MONTH: {
			return date.getMonth();
		}
		case SECOND: {
			return date.getSeconds();
		}
		case DAY_OF_WEEK: {
			final int day = date.getDay() + 1;
			// Window.alert(date + "=" + day);
			// int res = day - (getFirstDayOfWeek() -1);
			// if(res < 1){
			// res = 7 + res;
			// }
			return day;
			// break;
		}
		case DAY_OF_MONTH: {
			return date.getDate();
		}
		case DAY_OF_YEAR: {
			return getDayOfYear();
		}
		case YEAR: {
			return date.getYear();
		}
		case WEEK_OF_YEAR: {
			return getWeekOfYear();
		}

		}
		return 0;
	}

	private int getDayOfYear() {
		final Date firstDayOfYear = new Date(date.getYear(), 0, 0);
		return compareDate(firstDayOfYear, date);
	}

	private int getWeekOfYear() {
		final Date firstDayOfYear = new Date(date.getYear(), 0, 1);
		GregorianCalendar firstDayOfWeekNumber2 = new GregorianCalendar();
		firstDayOfWeekNumber2.setTime(new Date(date.getYear(), 0, 1 + 7));
		firstDayOfWeekNumber2.setToFirstDayOfCurrentWeek();

		int days = compareDate(firstDayOfWeekNumber2.getTime(), date);
		int count = 1;
		while (days > 0) {
			days = days - 7;
			count++;
		}
		return count;
	}

	public void set(int field, int value) {

		switch (field) {
		case HOUR: {
			date.setHours(value);
			break;
		}
		case HOUR_OF_DAY: {
			date.setHours(value);
			break;
		}

		case MINUTE: {
			date.setMinutes(value);
			break;
		}
		case MONTH: {
			date.setMonth(value);
			break;
		}
		case SECOND: {
			date.setSeconds(value);
			break;
		}
		case DAY_OF_WEEK: {
			final int dayOfWeek = get(DAY_OF_WEEK);
			// value = value - (super.getFirstDayOfWeek() -1);
			final int add = value - dayOfWeek;
			// Window.alert(date + ""+ value + "-" + dayOfWeek + "=" + add + " Result in " + date.getDay());
			if (add != 0) {
				date.setTime(addValue(date.getTime(), add, DATE));
			}

			break;
		}
		case DAY_OF_MONTH: {
			final int currentDayoffMonth = get(DAY_OF_MONTH);
			date.setTime(addValue(date.getTime(), value - currentDayoffMonth, DATE));
			break;
		}
		case DAY_OF_YEAR: {
			final int currentDayoffMonth = get(DAY_OF_YEAR);
			date.setTime(addValue(date.getTime(), value - currentDayoffMonth, DATE));
			break;
		}
		case YEAR: {
			date.setYear(value);
			break;
		}
		case WEEK_OF_YEAR: {
			final int week = getWeekOfYear();
			date.setTime(addValue(date.getTime(), (value - week) * 7, DATE));
			break;
		}

		}
	}

	public void add(int field, int value) {

		switch (field) {
		case HOUR: {
			date.setHours(date.getHours() + value);
			break;
		}
		case HOUR_OF_DAY: {
			date.setHours(date.getHours() + value);
			break;
		}

		case MINUTE: {
			date.setMinutes(date.getMinutes() + value);
			break;
		}
		case MONTH: {
			date.setTime(addValue(date.getTime(), value, MONTH));
			break;
		}
		case SECOND: {
			date.setSeconds(date.getSeconds() + value);
			break;
		}
		case DAY_OF_WEEK: {
			date.setTime(addValue(date.getTime(), value, DATE));
			break;
		}
		case DAY_OF_MONTH: {
			date.setTime(addValue(date.getTime(), value, DATE));
			break;
		}
		case DAY_OF_YEAR: {
			date.setTime(addValue(date.getTime(), value, DATE));
			break;
		}
		case YEAR: {
			date.setTime(addValue(date.getTime(), value, YEAR));
			break;
		}
		case WEEK_OF_YEAR: {
			date.setTime(addValue(date.getTime(), value * 7, DATE));
			break;
		}

		}
	}

	public static int daysInMonth(Date d) {
		final Date nd = new Date(GregorianCalendar.addValue(d.getTime(), 1, GregorianCalendar.MONTH));
		return GregorianCalendar.compareDate(d, nd);
	}

	/**
	 * Calculate the number of days betwen two dates
	 * 
	 * @param a
	 *            Date
	 * @param b
	 *            Date
	 * @return the difference in days betwen b and a (b - a)
	 */
	public static int compareDate(Date a, Date b) {
		final Date ta = new Date(a.getTime());
		final Date tb = new Date(b.getTime());
		final long d1 = setHourToZero(ta).getTime();
		final long d2 = setHourToTen(tb).getTime();
		return (int) ((d2 - d1) / 1000 / 60 / 60 / 24);
	}

	/**
	 * Set hour, minutes, second and milliseconds to zero.
	 * 
	 * @param d
	 *            Date
	 * @return Modified date
	 */

	public static Date setHourToZero(Date in) {
		final Date d = new Date(in.getTime());
		d.setHours(0);
		d.setMinutes(0);
		d.setSeconds(0);
		// a trick to set milliseconds to zero
		long t = d.getTime() / 1000;
		t = t * 1000;
		return new Date(t);
	}

	/**
	 * Set hour to 10, minutes, second and milliseconds to zero.
	 * 
	 * @param d
	 *            Date
	 * @return Modified date
	 */

	public static Date setHourToTen(Date in) {
		final Date d = new Date(in.getTime());
		d.setHours(10);
		d.setMinutes(0);
		d.setSeconds(0);
		// a trick to set milliseconds to zero
		long t = d.getTime() / 1000;
		t = t * 1000;
		return new Date(t);
	}

	public void setToFirstDayOfCurrentWeek() {
		int dayDiff = getFirstDayOfWeek() - get(DAY_OF_WEEK);
		if (dayDiff > 0) {
			add(DAY_OF_YEAR, (dayDiff - 7));
		} else {
			add(DAY_OF_YEAR, dayDiff);
		}
	}

	private static long addValue(long time, int value, int type) {
		Date date = new Date(time);
		switch (type) {
		case MONTH: {
			Date result = new Date(date.getYear(), date.getMonth() + value, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
			return result.getTime();
		}
		case DATE: {
			Date result = new Date(date.getYear(), date.getMonth(), date.getDate() + value, date.getHours(), date.getMinutes(), date.getSeconds());
			return result.getTime();
		}
		case YEAR: {
			Date result = new Date(date.getYear() + value, date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
			return result.getTime();

		}

		}
		return time;

	}
}
