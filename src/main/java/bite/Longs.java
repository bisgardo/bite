package bite;

public class Longs {
	public static final int WIDTH = 64;
	
	public static long one(int index) {
		return 1L << index;
	}
	
	public static long ones(int count) {
		return one(count) - 1;
	}
	
	public static boolean testBit(long value, int index) {
		value >>= index;
		return (value & 1) == 1;
	}
	
	public static long withBit(long value, int index, boolean bit) {
		return bit
				? setBit(value, index)
				: clearBit(value, index);
	}
	
	public static long setBit(long value, int index) {
		value |= 1 << index;
		return value;
	}
	
	public static long clearBit(long value, int index) {
		value &= ~(1 << index);
		return value;
	}
	
	public static long flipBit(long value, int index) {
		value ^= 1 << index;
		return value;
	}
	
	public static byte getByte0(long value) {
		return (byte) value;
	}
	
	public static byte getByte1(long value) {
		return (byte) (value >> 8);
	}
	
	public static byte getByte2(long value) {
		return (byte) (value >> 16);
	}
	
	public static byte getByte3(long value) {
		return (byte) (value >> 24);
	}
	
	public static byte getByte4(long value) {
		return (byte) (value >> 32);
	}
	
	public static byte getByte5(long value) {
		return (byte) (value >> 40);
	}
	
	public static byte getByte6(long value) {
		return (byte) (value >> 48);
	}
	
	public static byte getByte7(long value) {
		return (byte) (value >> 56);
	}
	
	public static long fromByte(byte value) {
		return value & ones(Bytes.WIDTH);
	}
	
	public static long fromBytes(
			byte byte7, byte byte6, byte byte5, byte byte4,
			byte byte3, byte byte2, byte byte1, byte byte0
	) {
		long result = byte7 << 8;
		result |= fromByte(byte6);
		result <<= 8;
		result |= fromByte(byte5);
		result <<= 8;
		result |= fromByte(byte4);
		result <<= 8;
		result |= fromByte(byte3);
		result <<= 8;
		result |= fromByte(byte2);
		result <<= 8;
		result |= fromByte(byte1);
		result <<= 8;
		result |= fromByte(byte0);
		return result;
	}
	
	public static short getShort0(long value) {
		return (short) value;
	}
	
	public static short getShort1(long value) {
		return (short) (value >> 16);
	}
	
	public static short getShort2(long value) {
		return (short) (value >> 32);
	}
	
	public static short getShort3(long value) {
		return (short) (value >> 48);
	}
	
	public static long fromShort(short value) {
		return (short) (value & ones(Shorts.WIDTH));
	}
	
	public static long fromShorts(short short3, short short2, short short1, short short0) {
		long result = short3 << 16;
		result |= fromShort(short2);
		result <<= 16;
		result |= fromShort(short1);
		result <<= 16;
		result |= fromShort(short0);
		return result;
	}
	
	public static int getInt0(long value) {
		return (int) (value >> 32);
	}
	
	public static int getInt1(long value) {
		return (int) value;
	}
	
	public static long fromInt(int value) {
		return value & ones(Ints.WIDTH);
	}
	
	public static long fromInts(int int1, int int0) {
		long result = (long) int1 << 32;
		result |= fromInt(int0);
		return result;
	}
	
	public static long get(long value, int offset, int length) {
		return value >> offset & ones(length);
	}
	
	public static long with(long value, long overlay, int offset, int length) {
		long mask = ones(length);
		return value & ~(mask << offset) | (overlay & mask) << offset;
	}
	
	public static long fromBinary(String binary) {
		long result = 0;
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
	
	public static String toBinary(long value) {
		return Long.toBinaryString(value);
	}
}
