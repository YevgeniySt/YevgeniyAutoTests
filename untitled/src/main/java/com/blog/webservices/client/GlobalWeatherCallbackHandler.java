
/**
 * GlobalWeatherCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.blog.webservices.client;

    /**
     *  GlobalWeatherCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GlobalWeatherCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GlobalWeatherCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GlobalWeatherCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCitiesByCountry method
            * override this method for handling normal response from getCitiesByCountry operation
            */
           public void receiveResultgetCitiesByCountry(
                    com.blog.webservices.client.GlobalWeatherStub.GetCitiesByCountryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCitiesByCountry operation
           */
            public void receiveErrorgetCitiesByCountry(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getWeather method
            * override this method for handling normal response from getWeather operation
            */
           public void receiveResultgetWeather(
                    com.blog.webservices.client.GlobalWeatherStub.GetWeatherResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getWeather operation
           */
            public void receiveErrorgetWeather(java.lang.Exception e) {
            }
                


    }
    