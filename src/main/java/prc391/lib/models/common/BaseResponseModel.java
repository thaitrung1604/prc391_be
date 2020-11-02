package prc391.lib.models.common;

public class BaseResponseModel {
    private boolean success;
    private String messageErr;
    private Object data;

    public BaseResponseModel(String messageErr) {
        this.messageErr = messageErr;
    }

    public BaseResponseModel(Object data) {
        this.data = data;
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessageErr() {
        return messageErr;
    }

    public void setMessageErr(String messageErr) {
        this.messageErr = messageErr;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
