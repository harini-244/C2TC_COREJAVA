package packageone;

public class PrimitiveDataTypesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte byteMax=127;
		byte byteMin=-128;
		System.out.println("Min range of byte is:"+byteMin+"Max range of byte is:"+byteMax);
		
		short shortMax=32767;
		short shortMin=-32768;
		System.out.println("Min short range of byte is:"+shortMin+"Max short range of byte is:"+shortMax);
		
		int maxInt=2147483647;
		int minInt=-2147483648;
		System.out.println("Min int range of byte is:"+minInt+"Max int range of byte is:"+maxInt);
		
		long maxLong=9223372036854775807L;
		long minLong=-9223372036854775808L;
		System.out.println("Minlong range of byte is:"+minLong+"Maxlong range of byte is:"+maxLong);
		
		float f=3234.141243278345f;
		double d=3456.14124512345678902345678914f;
		System.out.println("Float value is:"+f+"Double value is:"+d);
		
		boolean flag=false;
		System.out.println("Boolean value is:"+flag);
	}

}
