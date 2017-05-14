package bite;

public class Shorts {
	public static final int WIDTH = 16;
	
	public static short one(int index) {
		return (short) (1 << index);
	}
	
	public static short ones(int count) {
		return (short) (one(count) - 1);
	}
	
	public static boolean testBit(short value, int index) {
		value >>= index;
		return (value & 1) == 1;
	}
	
	public static short withBit(short value, int index, boolean bit) {
		return bit
				? setBit(value, index)
				: clearBit(value, index);
	}
	
	public static short setBit(short value, int index) {
		value |= 1 << index;
		return value;
	}
	
	public static short clearBit(short value, int index) {
		value &= ~(1 << index);
		return value;
	}
	
	public static short flipBit(short value, int index) {
		value ^= 1 << index;
		return value;
	}
	
	public static byte getByte0(short value) {
		return (byte) value;
	}
	
	public static byte getByte1(short value) {
		return (byte) (value >> 8);
	}
	
	public static short fromByte(byte value) {
		return (short) (value & ones(Bytes.WIDTH));
	}
	
	public static short fromBytes(byte byte1, byte byte0) {
		short result = (short) (byte1 << 8);
		result |= fromByte(byte0);
		return result;
	}
	
	public static short get(short value, int offset, int length) {
		return (short) (value >> offset & ones(length));
	}
	
	public static short with(short value, short overlay, int offset, int length) {
		short mask = ones(length);
		return (short) (value & ~(mask << offset) | (overlay & mask) << offset);
	}
	
	public static short fromBinary(String binary) {
		short result = 0;
		int length = binary.length();
		if (length > WIDTH) {
			throw new NumberFormatException();
		}
		
		//noinspection Duplicates
		for (int index = 0; index < length; index++) {
			result <<= 1;
			char digit = binary.charAt(index);
			if (digit == '1') {
				result |= 1;
			} else if (digit != '0') {
				throw new NumberFormatException();
			}
		}
		return result;
	}
	
	public static String toBinary(short value) {
		return Integer.toBinaryString(Ints.fromShort(value));
	}
}
