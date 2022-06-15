package com.base.scaffold.user.business.api;

import com.base.scaffold.user.business.request.base.AdapterBaseRequest;
import com.base.scaffold.user.business.request.base.BaseUserSrvRequest;
import com.base.scaffold.user.business.response.base.AdapterBaseResponse;
import com.base.scaffold.user.business.response.base.BaseUserSrvResponse;
import com.base.scaffold.user.service.union.BaseUserSrvService;
import lombok.Data;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 15:59
 * @description: RPC 请求工具类
 */
@Data
public class BaseUserSrvReqUtil<K extends AdapterBaseRequest, V extends AdapterBaseResponse> {

    private String api;
    private String version;
    private String ip;
    private String transId;
    private BaseUserSrvService<K, V> baseUserSrvService;

    private BaseUserSrvReqUtil() {
    }

    public BaseUserSrvReqUtil(String api, BaseUserSrvService<K, V> baseUserSrvService) {
        this.api = api;
        this.transId = UUID.randomUUID().toString();
        this.version = "1.0";
        this.ip = getIpAddresses();
        this.baseUserSrvService = baseUserSrvService;
    }

    public BaseUserSrvReqUtil(String api, String transId, BaseUserSrvService<K, V> baseUserSrvService) {
        this.api = api;
        this.transId = transId;
        this.ip = getIpAddresses();
        this.version = "1.0";
        this.baseUserSrvService = baseUserSrvService;
    }

    public BaseUserSrvReqUtil(String api, String transId, String ip, BaseUserSrvService<K, V> baseUserSrvService) {
        this.api = api;
        this.transId = transId;
        this.ip = ip;
        this.version = "1.0";
        this.baseUserSrvService = baseUserSrvService;
    }

    public BaseUserSrvReqUtil(String api, String transId, String ip, String version, BaseUserSrvService<K, V> baseUserSrvService) {
        this.api = api;
        this.transId = transId;
        this.ip = ip;
        this.version = version;
        this.baseUserSrvService = baseUserSrvService;
    }

    public BaseUserSrvResponse<V> rpc(K busiRequest) {
        BaseUserSrvRequest<K> baseUserSrvRequest = new BaseUserSrvRequest<>();
        baseUserSrvRequest.setTransId(null == transId ? UUID.randomUUID().toString() : transId);
        baseUserSrvRequest.setRequestIp(null == ip ? getIpAddresses() : ip);
        baseUserSrvRequest.setVersion(null == version ? "1.0" : version);
        baseUserSrvRequest.setTimestamp(System.currentTimeMillis());
        baseUserSrvRequest.setMethod(api);
        baseUserSrvRequest.setBusiRequest(busiRequest);
        return baseUserSrvService.dispatcher(baseUserSrvRequest);
    }

    private static String getIpAddresses() {

        String ip = "unknown";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            InetAddress localAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    if (!address.isLoopbackAddress() && !(address instanceof Inet6Address)) {
                        return address.getHostAddress();
                    } else if (!address.isLoopbackAddress()) {
                        localAddress = address;
                    }
                }
            }

            assert localAddress != null;
            ip = localAddress.getHostAddress();
        } catch (Exception ignored) {
        }
        return ip;
    }
}