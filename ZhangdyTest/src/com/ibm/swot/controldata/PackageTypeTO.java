//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************

package com.ibm.swot.controldata;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageTypeTO creates transfer objects which are used to build PackageTypeTO objects 
 * from PkgType.xml using apache digestor.
 * 
 * @author Jacky Li
 * @see com.ibm.swot.controldata.PackageTypeTO
 */
public class PackageTypeTO {
	private String id;

	private String name;

	private String key;

	private String packageOffering;

	private String packageCategoryId;

	private boolean isSupported;

	private boolean isInternetDeliverable;

	private String softwareInventoryUsage;

	private boolean usesVSLs;

	private boolean licCfgSupported;

	private boolean useAnnDates;

	private Set supportedInCountries = new HashSet();
	
	// PTR 5552
	private boolean isSupportEsp;
	
	public boolean isInternetDeliverable() {
		return isInternetDeliverable;
	}

	public void setInternetDeliverable(String _isInternetDeliverable) {
		this.isInternetDeliverable = Boolean.valueOf(_isInternetDeliverable).booleanValue();
	}

	public boolean isSupported() {
		return isSupported;
	}

	public void setSupported(String _isSupported) {
		this.isSupported = Boolean.valueOf(_isSupported).booleanValue();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String _key) {
		this.key = _key;
	}

	public String getSoftwareInventoryUsage() {
		return softwareInventoryUsage;
	}

	public void setSoftwareInventoryUsage(String _softwareInventoryUsage) {
		this.softwareInventoryUsage = _softwareInventoryUsage;
	}

	public Set getSupportedInCountries() {
		return supportedInCountries;
	}

	public void addSupportedInCountries(String _supportedInCountry) {
		supportedInCountries.add(_supportedInCountry);
	}
	
	public boolean usesVSLs() {
		return usesVSLs;
	}

	public void setUsesVSLs(String _usesVSLs) {
		this.usesVSLs = Boolean.valueOf(_usesVSLs).booleanValue();
	}

	public String getId() {
		return id;
	}

	public void setId(String _id) {
		this.id = _id;
	}

	public boolean isLicCfgSupported() {
		return licCfgSupported;
	}

	public void setLicCfgSupported(String _licCfgSupported) {
		this.licCfgSupported = Boolean.valueOf(_licCfgSupported).booleanValue();
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	public String getPackageCategoryId() {
		return packageCategoryId;
	}

	public void setPackageCategoryId(String _packageCategoryId) {
		this.packageCategoryId = _packageCategoryId;
	}

	public String getPackageOffering() {
		return packageOffering;
	}

	public void setPackageOffering(String _packageOffering) {
		this.packageOffering = _packageOffering;
	}

	public boolean useAnnDates() {
		return useAnnDates;
	}

	public void setUseAnnDates(String _useAnnDates) {
		this.useAnnDates = Boolean.valueOf(_useAnnDates).booleanValue();
	}
	// PTR 5552
	public boolean isSupportEsp() {
		return isSupportEsp;
	}
	// PTR 5552
	public void setSupportEsp(String _isSupportEsp) {
		this.isSupportEsp = Boolean.valueOf(_isSupportEsp).booleanValue();
	}
}
