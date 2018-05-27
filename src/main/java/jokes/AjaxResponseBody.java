package jokes;

/**
 * Response body used to handle responses from AJAX requests.
 */
public class AjaxResponseBody {
	private String msg;

	/**
	 * Get AJAX Response message.
	 * @return String msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Set AJAX response message.
	 * @param msg - response
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
