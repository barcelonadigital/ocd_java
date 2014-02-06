/**
 * LINKCARE_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.linkcare.LINKCARE;

public class LINKCARE_ServiceLocator extends org.apache.axis.client.Service implements es.linkcare.LINKCARE.LINKCARE_Service {

    public LINKCARE_ServiceLocator() {
    }


    public LINKCARE_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LINKCARE_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LINKCARE
    private java.lang.String LINKCARE_address = "http://localhost:8081/BDIGITAL-LCWS/ServerWSDL.php";

    public java.lang.String getLINKCAREAddress() {
        return LINKCARE_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LINKCAREWSDDServiceName = "LINKCARE";

    public java.lang.String getLINKCAREWSDDServiceName() {
        return LINKCAREWSDDServiceName;
    }

    public void setLINKCAREWSDDServiceName(java.lang.String name) {
        LINKCAREWSDDServiceName = name;
    }

    public es.linkcare.LINKCARE.LINKCARE_PortType getLINKCARE() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LINKCARE_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLINKCARE(endpoint);
    }

    public es.linkcare.LINKCARE.LINKCARE_PortType getLINKCARE(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.linkcare.LINKCARE.LINKCARESoapBindingStub _stub = new es.linkcare.LINKCARE.LINKCARESoapBindingStub(portAddress, this);
            _stub.setPortName(getLINKCAREWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLINKCAREEndpointAddress(java.lang.String address) {
        LINKCARE_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.linkcare.LINKCARE.LINKCARE_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                es.linkcare.LINKCARE.LINKCARESoapBindingStub _stub = new es.linkcare.LINKCARE.LINKCARESoapBindingStub(new java.net.URL(LINKCARE_address), this);
                _stub.setPortName(getLINKCAREWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LINKCARE".equals(inputPortName)) {
            return getLINKCARE();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://linkcare.es/LINKCARE", "LINKCARE");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://linkcare.es/LINKCARE", "LINKCARE"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LINKCARE".equals(portName)) {
            setLINKCAREEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
