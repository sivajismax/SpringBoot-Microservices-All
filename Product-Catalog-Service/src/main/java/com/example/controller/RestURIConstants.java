package com.example.controller;

public class RestURIConstants {

	public static final String PRODSERVICE_MAIN = "/api/pcs";
	public static final String PROD_CHECKUSER = "/checkuser/{username}";
	public static final String GET_PROD_ALL = "/productsall";
	public static final String GET_PROD_BYID = "/products/{id}";
	public static final String GET_PROD_BYMATCHNAME = "/products/byName/{matchletter}";
	public static final String POST_PROD = "/products";
	public static final String POST_PROD_ALL = "/products/all";
	public static final String GET_REVW_ALL = "/reviews";
	public static final String GET_REVW_BYPRODID = "/products/{id}/reviews";
	public static final String POST_REVW_FORPRODID = "/products/{id}/reviews";

}