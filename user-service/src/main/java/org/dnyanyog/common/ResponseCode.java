package org.dnyanyog.common;

public  enum ResponseCode { 
	 Add_User("User Added Sucessfully", "200") ,
	 Update_User("User Updated Sucessfully" , "200"),
	  Search_User("User Found ", "200"),
	   Delete_User("User Deleted Sucessfully ", "200"),
	    User_Not_Found("User Not Found ","404");
	    
	     private final String code ; 
	      private final String message ;  
	       
	       private ResponseCode(String code , String message ) { 
	    	    this.code = code ; 
	    	     this.message=message ; 
	    	    
	       } 
	        public String getCode() {
	        	return code ; 
	        } 
	         public String getMessage() {
	        	  return message ; 
	         }
	       

}
