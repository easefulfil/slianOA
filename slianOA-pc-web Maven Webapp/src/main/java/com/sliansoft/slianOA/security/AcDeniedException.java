package com.sliansoft.slianOA.security;


	@SuppressWarnings("serial")
	public class AcDeniedException extends RuntimeException
	{
		
	  public AcDeniedException(String msg)
	  {
	    super(msg);
	  }

	  public AcDeniedException(String msg, Throwable t)
	  {
	    super(msg, t);
	  }
	}


