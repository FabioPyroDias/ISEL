

public class MyMessage {
	private String s;
	
	public String getS() {
		return this.s;
	}
	
	public MyMessage(String _s) {
		this.s = new String( _s );
	}
	
	public MyMessage(byte[] _raw) {
		int dim = byteArrayToInt( _raw );
		
		byte[] sArray = new byte[ dim ];
		System.arraycopy(_raw, 4, sArray, 0, dim);
		
		this.s = new String( sArray );
	}
	
	
	private byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >>> 24),
                (byte)(value >>> 16),
                (byte)(value >>> 8),
                (byte)value};
	}
	
	private int byteArrayToInt(byte [] b) {
        return (b[0] << 24)
                + ((b[1] & 0xFF) << 16)
                + ((b[2] & 0xFF) << 8)
                + (b[3] & 0xFF);
	}
	
	public byte[] getData() {
		byte[] result;
		
		byte[] sArray = this.s.getBytes();
		
		int dim = sArray.length;
		
		byte[] dimArray = this.intToByteArray( dim );

		result = new byte[ dimArray.length + sArray.length ];
		
		System.arraycopy(dimArray, 0, result, 0, dimArray.length);
		System.arraycopy(sArray, 0, result, dimArray.length, sArray.length);

		return result;
	}
}
