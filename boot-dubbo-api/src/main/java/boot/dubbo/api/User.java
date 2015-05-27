package boot.dubbo.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户
 * 
 * @author percy
 *
 */
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户标识
	 */
	private Integer id;
	/**
	 * 用户姓名
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
