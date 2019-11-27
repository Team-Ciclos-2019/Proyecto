
package edu.eci.cvds.managedbeans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



 
@ManagedBean(name = "calendarBean", eager =true)
@SessionScoped
public class Calendar implements Serializable {
 
	private static final long serialVersionUID = 8995118759276351827L;


        private Date date;
	private Date date15;
	
	
	public Date getDate() {

		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
        public Date getDate15() {

		return date15;
	}
 
	public void setDate15(Date date) {
		this.date15 = date;
	}
}
