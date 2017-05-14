package bite;

public class Bytes {
	public static final int WIDTH = 8;
	
	public static byte one(int index) {
		return (byte) (1 << index);
	}
	
	public static byte ones(int count) {
		byte result = one(count);
		result--;
		return result;
	}
	
	public static boolean testBit(byte value, int index) {
		value >>= index;
		return (value & 1) == 1;
	}
	
	public static byte withBit(byte value, int index, boolean bit) {
		return bit
				? setBit(value, index)
				: clearBit(value, index);
	}
	
	public static byte setBit(byte value, int index) {
		value |= 1 << index;
		return value;
	}
	
	public static byte clearBit(byte value, int index) {
		value &= ~(1 << index);
		return value;
	}
	
	public static byte flipBit(byte value, int index) {
		value ^= 1 << index;
		return value;
	}
	
	public static byte fromBits(
			boolean bit7, boolean bit6, boolean bit5, boolean bit4,
			boolean bit3, boolean bit2, boolean bit1, boolean bit0
	) {
		byte result = 0;
		if (bit7) result |= 1 << 7;
		if (bit6) result |= 1 << 6;
		if (bit5) result |= 1 << 5;
		if (bit4) result |= 1 << 4;
		if (bit3) result |= 1 << 3;
		if (bit2) result |= 1 << 2;
		if (bit1) result |= 1 << 1;
		if (bit0) result |= 1;
		return result;
	}
	
	public static byte get(byte value, int offset, int length) {
		return (byte) (value >> offset & ones(length));
	}
	
	public static byte with(byte value, byte overlay, int offset, int length) {
		short mask = ones(length);
		return (byte) (value & ~(mask << offset) | (overlay & mask) << offset);
	}
	
	public static byte fromBinary(String binary) {
		byte result = 0;
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
	
	public static String toBinary(byte value) {
		return Integer.toBinaryString(Ints.fromByte(value));
	}
}
