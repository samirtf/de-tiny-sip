/*
* Conditions Of Use 
* 
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
* 
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
* 
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement.
* 
*/
package android.gov.nist.gnjvx.sip.header;

import android.javax.sip.address.*;
import android.javax.sip.header.FromHeader;
import android.javax.sip.header.HeaderAddress;
import android.javax.sip.header.Parameters;

import android.gov.nist.gnjvx.sip.address.*;

/** An abstract class for headers that take an address and parameters. 
 *
 * @version 1.2 $Revision: 1.10 $ $Date: 2008/09/03 15:44:37 $
 * 
 * @since 1.1
 *
 * @author M. Ranganathan   <br/>
 * 
 * 
 *
 * 
 */
public abstract class AddressParametersHeader extends ParametersHeader implements  Parameters {

	protected AddressImpl address;

	/* (non-Javadoc)
	 * @see android.gov.nist.gnjvx.sip.header.AddressParameters#getAddress()
	 */
	public Address getAddress() {
		return address;
	}

	/* (non-Javadoc)
	 * @see android.gov.nist.gnjvx.sip.header.AddressParameters#setAddress(android.javax.sip.address.Address)
	 */
	public void setAddress(Address address) {
		this.address = (AddressImpl) address;
	}

	/**
	 * Constructor given the name of the header.
	 */
	protected AddressParametersHeader(String name) {
		super(name);
	}
	
	/**
	 * Constructor given a synch flag.
	 * 
	 * @param name
	 * @param sync
	 */
	
	protected AddressParametersHeader(String name, boolean sync) {
		super(name,sync);
	}

	/* (non-Javadoc)
	 * @see android.gov.nist.gnjvx.sip.header.AddressParameters#clone()
	 */
	public Object clone() {
		AddressParametersHeader retval = (AddressParametersHeader) super.clone();
		if (this.address != null)
			retval.address = (AddressImpl) this.address.clone();
		return retval;
	}
	
	/* (non-Javadoc)
	 * @see android.gov.nist.gnjvx.sip.header.AddressParameters#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this==other) return true;
		
		
		
		if (other instanceof HeaderAddress && other instanceof Parameters) {
			final HeaderAddress o = (HeaderAddress) other;
			return this.getAddress().equals( o.getAddress() ) && this.equalParameters( (Parameters) o );	
		}
		return false;
	}
	
}
