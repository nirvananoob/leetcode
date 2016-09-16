package Google_OA;

public class question2 {
  public String maxsub(String  a) {
	  String b = a;
	  char maxchar = a.charAt(0);
	  for(int i = 1; i < a.length(); ++i ) {
		  char c = a.charAt(i);
		  if(c > maxchar) {
			  c  = maxchar;
			  b  = a.substring(i,a.length());
		  }else if(c < maxchar){
			  continue;
		  }else{
			  if(b.compareTo(a.substring(i,a.length())) < 0){
				  b = a.substring(i, a.length());
			  }
		  }
	  }
	  return b;
  }
}
