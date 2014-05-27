package org.javalusir.design_model.singleon;
/**
 * singlon demo
 * @author javalusir
 *
 */
public class Singleon {
	private static Singleon s = null;
	private Singleon (){
	}
	public static Singleon getinstance(){
		if(s==null)
			s=new Singleon();
		return s;
	}
}
