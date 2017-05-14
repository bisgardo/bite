package bite;

public class Ints {
	public static final int WIDTH = 32;
	
	public static int one(int index) {
		return 1 << index;
	}
	
	public static int ones(int count) {
		return one(count) - 1;
	}
	
	public static boolean testBit(int value, int index) {
		value >>= index;
		return (value & 1) == 1;
	}
	
	public static int withBit(int value, int index, boolean bit) {
		return bit
				? setBit(value, index)
				: clearBit(value, index);
	}
	
	public static int setBit(int value, int index) {
		value |= 1 << index;
		return value;
	}
	
	public static int clearBit(int value, int index) {
		value &= ~(1 << index);
		return value;
	}
	
	public static int flipBit(int value, int index) {
		value ^= 1 << index;
		return value;
	}
	
	public static byte getByte0(int value) {
		return (byte) value;
	}
	
	public static byte getByte1(int value) {
		return (byte) (value >> 8);
	}
	
	public static byte getByte2(int value) {
		return (byte) (value >> 16);
	}
	
	public static byte getByte3(int value) {
		return (byte) (value >> 24);
	}
	
	public static int fromByte(byte value) {
		return value & ones(Bytes.WIDTH);
	}
	
	public static int fromBytes(byte byte3, byte byte2, byte byte1, byte byte0) {
		int result = (int) byte3 << 8;
		result |= fromByte(byte2);
		result <<= 8;
		result |= fromByte(byte1);
		result <<= 8;
		result |= fromByte(byte0);
		return result;
	}
	
	public static short getShort0(int value) {
		return (short) value;
	}
	
	public static short getShort1(int value) {
		return (short) (value >> 16);
	}
	
	public static int fromShort(short value) {
		return (short) (value & ones(Shorts.WIDTH));
	}
	
	public static int fromShorts(short short1, short short0) {
		int result = short1 << 16;
		result |= fromShort(short0);
		return result;
	}
	
	public static int get(int value, int offset, int length) {
		return value >> offset & ones(length);
	}
	
	public static int with(int value, int overlay, int offset, int length) {
		int mask = ones(length);
		return value & ~(mask << offset) | (overlay & mask) << offset;
	}
	
	public static int fromBinary(String binary) {
		// TODO Implement (trivial) optimized solution.
		long result = Long.parseLong(binary, 2);
		if (result >> WIDTH != 0) {
			throw new NumberFormatException();
		}
		return (int) result;
	}
	
	public static String toBinary(int value) {
		return Integer.toBinaryString(value);
	}
}
