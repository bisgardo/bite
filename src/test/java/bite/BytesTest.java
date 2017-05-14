package bite;

import org.junit.Test;

import static bite.Bytes.*;
import static org.junit.Assert.*;

public class BytesTest {
	
	@Test
	public void test_one() {
		assertEquals(fromBinary("1"), one(0));
		assertEquals(fromBinary("10"), one(1));
		assertEquals(fromBinary("100"), one(2));
		// ...
		assertEquals(fromBinary("1000000"), one(6));
		assertEquals(fromBinary("10000000"), one(7));
		
	}
	
	@Test
	public void test_ones() {
		assertEquals(fromBinary("0"), ones(0));
		assertEquals(fromBinary("1"), ones(1));
		assertEquals(fromBinary("11"), ones(2));
		// ...
		assertEquals(fromBinary("111111"), ones(6));
		assertEquals(fromBinary("1111111"), ones(7));
	}
	
	@Test
	public void test_testBit() {
		assertTrue(testBit(fromBinary("100101"), 0));
		assertFalse(testBit(fromBinary("100101"), 1));
		assertTrue(testBit(fromBinary("100101"), 2));
		assertFalse(testBit(fromBinary("100101"), 3));
		assertFalse(testBit(fromBinary("100101"), 4));
		assertTrue(testBit(fromBinary("100101"), 5));
		assertFalse(testBit(fromBinary("100101"), 6));
		assertFalse(testBit(fromBinary("100101"), 7));
	}
	
	@Test
	public void test_setBit() {
		assertEquals(fromBinary("100101"), setBit(fromBinary("100101"), 0));
		assertEquals(fromBinary("100111"), setBit(fromBinary("100101"), 1));
		assertEquals(fromBinary("100101"), setBit(fromBinary("100101"), 2));
		assertEquals(fromBinary("101101"), setBit(fromBinary("100101"), 3));
		assertEquals(fromBinary("110101"), setBit(fromBinary("100101"), 4));
		assertEquals(fromBinary("100101"), setBit(fromBinary("100101"), 5));
		assertEquals(fromBinary("1100101"), setBit(fromBinary("100101"), 6));
		assertEquals(fromBinary("10100101"), setBit(fromBinary("100101"), 7));
	}
	
	@Test
	public void test_clearBit() {
		assertEquals(fromBinary("100100"), clearBit(fromBinary("100101"), 0));
		assertEquals(fromBinary("100101"), clearBit(fromBinary("100101"), 1));
		assertEquals(fromBinary("100001"), clearBit(fromBinary("100101"), 2));
		assertEquals(fromBinary("100101"), clearBit(fromBinary("100101"), 3));
		assertEquals(fromBinary("100101"), clearBit(fromBinary("100101"), 4));
		assertEquals(fromBinary("000101"), clearBit(fromBinary("100101"), 5));
		assertEquals(fromBinary("100101"), clearBit(fromBinary("100101"), 6));
		assertEquals(fromBinary("100101"), clearBit(fromBinary("100101"), 7));
	}
	
	@Test
	public void test_flipBit() {
		assertEquals(fromBinary("100100"), flipBit(fromBinary("100101"), 0));
		assertEquals(fromBinary("100111"), flipBit(fromBinary("100101"), 1));
		assertEquals(fromBinary("100001"), flipBit(fromBinary("100101"), 2));
		assertEquals(fromBinary("101101"), flipBit(fromBinary("100101"), 3));
		assertEquals(fromBinary("110101"), flipBit(fromBinary("100101"), 4));
		assertEquals(fromBinary("000101"), flipBit(fromBinary("100101"), 5));
		assertEquals(fromBinary("1100101"), flipBit(fromBinary("100101"), 6));
		assertEquals(fromBinary("10100101"), flipBit(fromBinary("100101"), 7));
	}
	
	@Test
	public void test_fromBits() {
		assertEquals(
				fromBinary("100101"),
				fromBits(
						false, false,
						true, false, false, true, false, true
				)
		);
		assertEquals(
				fromBinary("11011010"),
				fromBits(
						true, true,
						false, true, true, false, true, false
				)
		);
	}
}
