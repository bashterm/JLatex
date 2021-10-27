package jlatex.util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jlatex.layout.LatexMeasurement;

/**
 * Represents a set of key-value pairs in a comma separated list.  These can be used
 * in a LatexCommandParameter or wherever key/value pairs are needed.
 * 
 * @author Michael Oland
 *
 */
public class LatexKeyValueList implements LatexContent
{
	private Map<String, LatexKeyValuePair<?, ?>> values = new HashMap<>();

	/**
	 * Gets a specific key/value pair for a given key.
	 * 
	 * @param key Key
	 * @return Corresponding key/value pair
	 */
	public LatexKeyValuePair<?, ?> getValue(String key)
	{
		return values.get(key);
	}

	/**
	 * Sets a specific key/value pair.
	 * 
	 * @param pair Key/value pair.
	 */
	public void setValue(LatexKeyValuePair<?, ?> pair)
	{
		values.put(pair.key, pair);
	}

	/**
	 * Sets a specific key/value pair.
	 * 
	 * @param pair Key/value pair.
	 * @return This
	 */
	public LatexKeyValueList value(LatexKeyValuePair<?, ?> pair)
	{
		this.setValue(pair);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		boolean first = true;

		for (LatexKeyValuePair<?, ?> e : values.values())
		{
			if (first)
			{
				first = false;
			}
			else
			{
				writer.write(',');
			}

			e.write(writer);
		}
	}

	/**
	 * Represents a key to string value pair.
	 * 
	 * @author Michael Oland
	 *
	 */
	public static class LatexStringKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, String>
	{
		public LatexStringKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(String value)
		{
			return value;
		}
	}

	/**
	 * Represents a key to measurement value pair.
	 * 
	 * @author Michael Oland
	 *
	 */
	public static class LatexMeasurementKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, LatexMeasurement>
	{
		public LatexMeasurementKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(LatexMeasurement value)
		{
			return value.write();
		}
	}

	/**
	 * Represents a key to integer pair.
	 * 
	 * @author Michael Oland
	 *
	 */
	public static class LatexIntegerKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, Integer>
	{
		public LatexIntegerKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(Integer value)
		{
			return value.toString();
		}
	}

	/**
	 * Represents a key to boolean value pair.
	 * 
	 * @author Michael Oland
	 *
	 */
	public static class LatexBooleanKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, Boolean>
	{
		public LatexBooleanKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(Boolean value)
		{
			return value.toString();
		}
	}

	/**
	 * Represents a key with no value.
	 * 
	 * @author Michael Oland
	 *
	 */
	public static class LatexKeyOnlyPair extends LatexKeyValuePair<LatexKeyOnlyPair, Void>
	{
		public LatexKeyOnlyPair(String key)
		{
			super(key);
		}

		@Override
		public void setValue(Void value)
		{
			throw new UnsupportedOperationException("setValue is not supported on LatexKeyOnlyPair");
		}

		@Override
		protected String formatValue(Void value)
		{
			return "";
		}
	}

	/**
	 * Represents an abstract key-value pair in a LaTeX command parameter.
	 * 
	 * @author Michael Oland
	 *
	 * @param <T> Subclass for builder paradigm
	 * @param <V> Value type
	 */
	public static abstract class LatexKeyValuePair<T, V> implements LatexContent
	{
		private final String key;
		private V value;

		protected LatexKeyValuePair(String key)
		{
			this.key = key;
		}

		public V getValue()
		{
			return value;
		}

		public void setValue(V value)
		{
			this.value = value;
		}

		@SuppressWarnings("unchecked")
		public T value(V value)
		{
			this.setValue(value);
			return (T) this;
		}

		public String getKey()
		{
			return key;
		}

		@Override
		public void write(PrintWriter writer)
		{
			if (this instanceof LatexKeyOnlyPair)
			{
				writer.print(key);
				return;
			}

			if (value == null)
			{
				return;
			}

			writer.format("%s=%s", key, formatValue(value));
		}

		protected abstract String formatValue(V value);
	}
}
