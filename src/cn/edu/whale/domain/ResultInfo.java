package cn.edu.whale.domain;

/**
 * @Author: hexin Liu
 * @Description: 用于封装后端返回给前端的数据对象
 * @Date: Created in 18:02 2019/11/2
 * @Modified By：
 */
public class ResultInfo {
    private boolean flag;//后端返回结果正常为true，异常为false
    private Object data;//后端返回结果数据对象
    private String errorMsg;//发生异常的错误消息

    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultInfo() {
    }
}
