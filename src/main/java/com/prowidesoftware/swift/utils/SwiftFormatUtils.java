/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.utils;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.model.LogicalTerminalAddress;
import com.prowidesoftware.swift.model.MIR;
import com.prowidesoftware.swift.model.MOR;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class provides methods to convert field components to objects.
 * It handles for example; dates, currencies and general functions defined in the SWIFT standard.
 * <ul>
 * 		<li>DATE1 MMDD</li>
 * 		<li>DATE2 YYMMDD</li>
 * 		<li>DATE3 YYMM</li>
 * 		<li>DATE4 YYYYMMDD</li>
 * 		<li>YEAR YYYY</li>
 * 		<li>AMOUNT ###,### (digits with comma as decimal separator)</li>
 * 		<li>TIME2 HHmmss</li>
 * 		<li>TIME3 HH[mm]</li>
 * 		<li>BOOL Y/N</li>
 * 		<li>DATETIME YYYYMMDDHHMM</li>
 * 		<li>DATETIME with short year YYMMDDHHMM</li>
 * 		<li>DAYTIME DDHHMM</li>
 * 		<li>MONTHDAY MMDD</li>
 * 		<li>MIR</li>
 * 		<li>MOR</li>
 * </ul>
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class SwiftFormatUtils {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftFormatUtils.class.getName());

	// Suppress default constructor for noninstantiability
	private SwiftFormatUtils() {
		throw new AssertionError();
	}

	/**
	 * Parses a DATE2 string (accept dates in format YYMMDD) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 */
	public static Calendar getDate2(final String strDate) {
		if ((strDate != null) && (strDate.length() == 6)) {
			return getCalendar(strDate, "yyMMdd");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a DATE2 string.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 */
	public static String getDate2(final Calendar date) {
		return getCalendar(date, "yyMMdd");
	}

	/**
	 * Parses a DATE1 string (accept dates in format MMDD) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 * @see #getMonthDay(String)
	 */
	public static Calendar getDate1(final String strDate) {
		return getMonthDay(strDate);
	}

	/**
	 * returns true if the the current year is a leap year
	 * @since 7.8.8
	 * @deprecated use Year.now().isLeap() instead
	 */
	@ProwideDeprecated(phase2 = TargetYear.SRU2021)
	public static final boolean isLeapYear() {
		return Year.now().isLeap();
	}
	
	/**
	 * returns true if the parameter year is a leap year
	 * @since 7.8.8
	 */
	public static final boolean isLeapYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}

	/**
	 * Parses a Calendar object into a DATE1 string.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 6.4
	 * @see #getMonthDay(Calendar)
	 */
	public static String getDate1(final Calendar date) {
		return getMonthDay(date);
	}

	/**
	 * Parses a DATE3 string (accept dates in format YYMM) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 */
	public static Calendar getDate3(final String strDate) {
		if ((strDate != null) && (strDate.length() == 4)) {
			return getCalendar(strDate, "yyMM");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a DATE1 string.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 6.4
	 */
	public static String getDate3(final Calendar date) {
		return getCalendar(date, "yyMM");
	}

	/**
	 * Parses a DATE4 string (accept dates in format YYYYMMDD) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 */
	public static Calendar getDate4(final String strDate) {
		if ((strDate != null) && (strDate.length() == 8)) {
			return getCalendar(strDate, "yyyyMMdd");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a DATE1 string.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 6.4
	 */
	public static String getDate4(final Calendar date) {
		return getCalendar(date, "yyyyMMdd");
	}

	/**
	 * Parses a YEAR string (accept dates in format YYYY) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 */
	public static Calendar getYear(final String strDate) {
		if ((strDate != null) && (strDate.length() == 4)) {
			return getCalendar(strDate, "yyyy");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a YYYY string.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 6.4
	 */
	public static String getYear(final Calendar date) {
		return getCalendar(date, "yyyy");
	}

	/**
	 * Parses a value into a java Number (BigDecimal) using the comma for decimal separator.
	 * @param amount to parse
	 * @return Number of the parsed amount or null if the number could not be parsed
	 */
	public static Number getNumber(final String amount) {
		Number number = null;
		if (amount != null) {
			try {
				final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
				symbols.setDecimalSeparator(',');
				final DecimalFormat df = new DecimalFormat("00.##", symbols);
				df.setParseBigDecimal(true);
				number = df.parse(amount);
			} catch (final ParseException e) {
				log.log(java.util.logging.Level.WARNING, "Error parsing number", e);
			}
		}
		return number;
	}

	/**
	 * Parses a Number into a SWIFT string number ####,## with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param number to parse
	 * @return Number of the parsed amount or null if the number is null
	 */
	public static String getNumber(final Number number) {
		if (number != null) {
			final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setDecimalSeparator(',');
			final DecimalFormat df = new DecimalFormat("0.##########", symbols);
			df.setParseBigDecimal(true);
			df.setDecimalSeparatorAlwaysShown(true);
			final String formatted = df.format(number);
			final String result = StringUtils.replaceChars(formatted, '.', ',');
			return result;
		}
		return null;
	}

	/**
	 * Converts the given time into a Calendar.
	 * Only the time information is set, the date will be the default 1/1/70
	 * @param hhmm hour and minutes
	 * @return a Calendar set with the given hour and minutes
	 */
	public static Calendar getHhmm(final String hhmm) {
		if ((hhmm != null) && (hhmm.length() == 4)) {
			return getCalendar(hhmm, "HHmm");
		} else {
			return null;
		}
	}

	private static Calendar getCalendar(final String value, final String format) {
		if (value != null) {
			try {
				final SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.setLenient(false);
				final Date d = sdf.parse(value);
				final Calendar cal = new GregorianCalendar();
				cal.setTime(d);
				return cal;
			} catch (final ParseException e) {
				log.log(java.util.logging.Level.WARNING, "Could not parse '"+value+"' with pattern '"+format+"'");
			}
		}
		return null;
	}

	/**
	 * @since 6.4
	 */
	private static String getCalendar(final Calendar date, final String format) {
		if (date != null) {
			return DateFormatUtils.format(date.getTime(), format);
		}
		return null;
	}

	/**
	 * Converts the given time into a Calendar.
	 * Only the time information is set, the date will be the default 1/1/70
	 * @param hhmmss hour, minutes and seconds
	 * @return a Calendar set with the given hour, minutes and seconds
	 */
	public static Calendar getTime2(final String hhmmss) {
		if ((hhmmss != null) && (hhmmss.length() == 6)) {
			return getCalendar(hhmmss, "HHmmss");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a TIME2 string.
	 * @param date Calendar to parse
	 * @return parsed time or null if the calendar is null
	 * @since 6.4
	 */
	public static String getTime2(final Calendar date) {
		return getCalendar(date, "HHmmss");
	}

	/**
	 * Converts the given time into a Calendar.
	 * Only the time information is set, the date will be the default 1/1/70
	 * @param hhmmss hour, minutes and seconds
	 * @return a Calendar set with the given hour, or and hour and minutes
	 */
	public static Calendar getTime3(final String hhmmss) {
		if (hhmmss != null) {
			if (hhmmss.length() == 2) {
				return getCalendar(hhmmss, "HH");
			} else if (hhmmss.length() == 4) {
				return getCalendar(hhmmss, "HHmm");
			}
		}
		return null;
	}

	/**
	 * Parses a Calendar object into a TIME3 string.
	 * @param date Calendar to parse
	 * @return parsed time or null if the calendar is null
	 * @since 6.4
	 */
	public static String getTime3(final Calendar date) {
		return getCalendar(date, "HHmm");
	}

	/**
	 * @param string with a single character
	 * @return the Character for the given string
	 */
	public static Character getSign(final String string) {
		if (StringUtils.isNotEmpty(string)) {
			return Character.valueOf(string.charAt(0));
		}
		return null;
	}

	/**
	 * @param string with an offset
	 * @return a Calendar set with hour and minutes from the offset
	 */
	public static Calendar getOffset(final String string) {
		final Calendar result = getHhmm(string);
		return result;
	}

	/**
	 * Parses a Calendar object into a offset string.
	 * @param date Calendar to parse
	 * @return parsed time or null if the calendar is null
	 * @since 6.4
	 */
	public static String getOffset(final Calendar date) {
		return getCalendar(date, "HHmm");
	}

	/**
	 * Returns the <code>Currency</code> instance for the given currency code.
	 * @param code string with a currency code
	 * @return a Currency initialized from the parameter code or null if parameter code is null
	 * @throws IllegalArgumentException if currencyCode is not a supported ISO 4217 code.
	 */
	public static Currency getCurrency(final String code) {
		if (code != null) {
			return Currency.getInstance(code);
		} else {
			return null;
		}
	}

	/**
	 * Gets the currency code from the parameter Currency.
	 * @param currency Currency to use
	 * @return the string with the currency code
	 * @since 6.4
	 */
	public static String getCurrency(final Currency currency) {
		return currency.getCurrencyCode();
	}

	/**
	 * @param code string with a BIC code
	 * @return a BIC initialized from the parameter code
	 */
	public static BIC getBIC(final String code) {
		return new BIC(code);
	}

	/**
	 * Gets the code from the parameter BIC.
	 * If branch is present, returns a BIC11, otherwise returns a BIC8.
	 * @param bic BIC to use
	 * @return the string with the BIC code
	 * @since 6.4
	 */
	public static String getBIC(final BIC bic) {
		if (StringUtils.isBlank(bic.getBranch())) {
			return bic.getBic8();
		} else {
			return bic.getBic11();
		}
	}

	/**
	 * Gets the given string as boolean.
	 * @param string code to use where the expected values are "Y" or "N"
	 * @return true for "Y", false for "N", and null otherwise
	 * @since 7.4
	 */
	public static Boolean getBoolean(final String string) {
		if (StringUtils.equals("Y", string)) {
			return Boolean.TRUE;
		} else if (StringUtils.equals("N", string)) {
			return Boolean.FALSE;
		} else {
			return null;
		}
	}

	/**
	 * Parses a Boolean object into a string.
	 * @param bool Boolean to parse
	 * @return parsed boolean converted to "Y" or "N" or null if the boolean object is null
	 * @since 7.4
	 */
	public static String getBoolean(final Boolean bool) {
		if (bool == null) {
			return null;
		}
		return bool? "Y": "N";
	}

	/**
	 * Parses a DATETIME string (accepts dates with time in YYYYMMDDHHMM format) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 * @since 7.4
	 */
	public static Calendar getDateTime(final String strDate) {
		if ((strDate != null) && (strDate.length() == 12)) {
			return getCalendar(strDate, "yyyyMMddHHmm");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a string containing the DATETIME with YYYYMMDDHHMM format.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 7.4
	 */
	public static String getDateTime(final Calendar date) {
		return getCalendar(date, "yyyyMMddHHmm");
	}

	/**
	 * Parses a DATETIME with short year string (accepts dates with time in YYMMDDHHMM format) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 * @since 7.4
	 */
	public static Calendar getDateTimeShortYear(final String strDate) {
		if ((strDate != null) && (strDate.length() == 10)) {
			return getCalendar(strDate, "yyMMddHHmm");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a DATETIME with short year string in YYMMDDHHMM format.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 7.4
	 */
	public static String getDateTimeShortYear(final Calendar date) {
		return getCalendar(date, "yyMMddHHmm");
	}

	/**
	 * Parses a DAYTIME string (accepts dates with time in DDHHMM format) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 * @since 7.4
	 */
	public static Calendar getDayTime(final String strDate) {
		if ((strDate != null) && (strDate.length() == 6)) {
			return getCalendar(strDate, "ddHHmm");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a string containing the DAYTIME in DDHHMM format.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 7.4
	 */
	public static String getDayTime(final Calendar date) {
		return getCalendar(date, "ddHHmm");
	}

	/**
	 * Parses a MONTHDAY string (accepts dates in MMDD format) into a Calendar object.
	 * <p>The year is set to the current year.
	 * The implementation will log a warning and return null if 0229 is passed as argument and the current year is not
	 * a leap year.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 * @since 7.4
	 */
	public static Calendar getMonthDay(final String strDate) {
		if ((strDate != null) && (strDate.length() == 4)) {
			String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			return getCalendar(year + strDate, "yyyyMMdd");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a string containing MONTHDAY in MMDD format.
	 * For February 29 it will return null if current year is not a leap year.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 7.4
	 */
	public static String getMonthDay(final Calendar date) {
		return getCalendar(date, "MMdd");
	}

	/**
	 * Parses an HOUR string (accepts time in HH format) into a Calendar object.
	 * @param strDate string to parse
	 * @return parsed date or null if the argument did not matched the expected date format
	 * @since 7.4
	 */
	public static Calendar getHour(final String strDate) {
		if ((strDate != null) && (strDate.length() == 2)) {
			return getCalendar(strDate, "HH");
		} else {
			return null;
		}
	}

	/**
	 * Parses a Calendar object into a string containing the HOUR in HH format.
	 * @param date Calendar to parse
	 * @return parsed date or null if the calendar is null
	 * @since 7.4
	 */
	public static String getHour(final Calendar date) {
		return getCalendar(date, "HH");
	}

	/**
	 * Parses a string value into a MIR object.
	 * @param value string containing the complete MIR value
	 * @return a MIR object containing the parsed data or null if the argument is not a 28 length string with a proper MIR data
	 * @see com.prowidesoftware.swift.model.MIR
	 */
	public static MIR getMIR(final String value) {
		if (value != null && value.length() == 28) {
			return new MIR(value);
		} else {
			return null;
		}
	}

	/**
	 * Parses a MIR object into a string containing its serialized data.
	 * @param mir MIR to process
	 * @return serialized content of the MIR object or null if the parameter is empty or null
	 * @since 7.4
	 * @see MIR#getMIR()
	 */
	public static String getMIR(final MIR mir) {
		if (mir != null) {
			return mir.getMIR();
		} else {
			return null;
		}
	}

	/**
	 * Parses a string value into a MOR object.
	 * @param value string containing the complete MOR value
	 * @return a MOR object containing the parsed data or null if the argument is not a 28 length string with a proper MOR data
	 * @see com.prowidesoftware.swift.model.MOR
	 */
	public static MOR getMOR(final String value) {
		if (value != null && value.length() == 28) {
			return new MOR(value);
		} else {
			return null;
		}
	}

	/**
	 * Parses a MOR object into a string containing its serialized data.
	 * @param mor MOR to process
	 * @return serialized content of the MOR object or null if the parameter is empty or null
	 * @since 7.4
	 * @see MOR#getMOR()
	 */
	public static String getMOR(final MOR mor) {
		if (mor != null) {
			return mor.getMOR();
		} else {
			return null;
		}
	}

	/**
	 * Tell if <code>string</code> is a valid currency code using Currency isntances from Java
	 * @param string the string to test for a currency code
	 * @return true if string is a valid currency code and false in other case, including null and empty
	 * @deprecated use {@link IsoUtils#isValidISOCurrency(String)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	public static boolean isCurrency(final String string) {
		DeprecationUtils.phase2(SwiftFormatUtils.class, "isCurrency(String)", "use IsoUtils#isValidISOCurrency(String) instead");
		if (StringUtils.isNotBlank(string)) {
			try {
				return Currency.getInstance(string)!=null;
			} catch (final Exception ignored) {}
		}
		return false;
	}
	
	/**
	 * Return the number of decimals for a string with a swift formatted amount.
	 * 
	 * @param amountString may be null or empty, in which case this method returns 0
	 * @return the number of digits after the last , or 0 in any other case.
	 * @since 7.8
	 */
	public static int decimalsInAmount(final String amountString) {
		if (StringUtils.isNotEmpty(amountString)) {
			final String tail = StringUtils.trim(StringUtils.substringAfterLast(amountString, ","));
			return tail.length();
		}
		return 0;
	}
	
	/**
	 * Return the number of decimals for the given number, which can be null, in which case this method returns zero.
	 * 
	 * @return the number of decimal in the number or zero if there are none or the amount is null
	 * @since 7.8
	 */
	public static int decimalsInAmount(final BigDecimal amount) {
		if (amount != null) {
			BigDecimal d = new BigDecimal(amount.toString());
			BigDecimal result = d.subtract(d.setScale(0, RoundingMode.FLOOR)).movePointRight(d.scale());
			if (result.intValue() != 0) {
				return result.toString().length();
			}
		}
		return 0;
	}
	
	/**
	 * @param address string with a LT identifier code (12 chars) composed by the
	 * BIC, LT identifier and branch.
	 * @return a LT address initialized from the parameter code
	 * @since 7.8.8
	 */
	public static final LogicalTerminalAddress getLTAddress(final String address) {
		return new LogicalTerminalAddress(address);
	}

	/**
	 * Gets the code from the parameter LogicalTerminalAddress.
	 * If the address is not complete, it will be filled with default values
	 * using {@link LogicalTerminalAddress#getSenderLogicalTerminalAddress()}
	 * @param address LT address to use
	 * @return the string with the full 12 characters long LT identifier
	 * @since 7.8.8
	 */
	public static final String getLTAddress(final LogicalTerminalAddress address) {
		return address.getSenderLogicalTerminalAddress();
	}
}
