package com.MO.Software.Bill.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.MO.Software.Bill.billProducts.DTO.billProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize(builder = billDTO.Builder.class)
public class billDTO {

    private Long id;
    private String employeeName;
    private Long employeeId;
    private Long dayId;
    private Integer billDayCounter;
    public billDTO (){}
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime dateTime;
    private Double billTotal;
    private Double billPayed;
    private Double billRemained;
    private Long customerId;
    private String customerName;
    private Integer billTypeId;
    private String billTypeName;
    private List<billProductDTO> billProductModelList =new ArrayList<billProductDTO>();
    private boolean returnedBill;
  
//    private billDTO(Builder builder) {
//        this.id = builder.id;
//        this.employeeName = builder.employeeName;
//        this.employeeId = builder.employeeId;
//        this.dayId = builder.dayId;
//        this.dateTime = builder.dateTime != null ? builder.dateTime : LocalDateTime.now();
//        this.billTotal = builder.billTotal;
//        this.billPayed = builder.billPayed;
//        this.billRemained = builder.billRemained;
//        this.customerId = builder.customerId;
//        this.customerName = builder.customerName;
//        this.billTypeId = builder.billTypeId;
//        this.billProductModelList=builder.billProductModelList;
//        this.billTypeName=builder.billTypeName;
//        this.returnedBill=builder.returnedBill;
//    }
//
//    public static class Builder {
//        private Long id;
//        private String employeeName;
//        private Long employeeId;
//        private Long dayId;
//        private LocalDateTime dateTime;
//        private Integer billTotal;
//        private Integer billPayed;
//        private Integer billRemained;
//        private Long customerId;
//        private String customerName;
//        private Integer billTypeId;
//        private List<billProductDTO> billProductModelList=new ArrayList<>();
//        private String billTypeName;
//        private boolean returnedBill;
//        
//        public Builder returnedBill(boolean returnedBill)
//        {
//        	this.returnedBill=returnedBill;
//        	return this;
//        }
//        public Builder billTypeName(String billTypeName)
//        {
//        	this.billTypeName=billTypeName;
//        	return this;
//        }
//        public Builder billProductModelList(List<billProductDTO> billProductModelList)
//        {
//        	this.billProductModelList=billProductModelList;
//        	return this;
//        }
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder employeeName(String employeeName) {
//            this.employeeName = employeeName;
//            return this;
//        }
//
//        public Builder employeeId(Long employeeId) {
//            this.employeeId = employeeId;
//            return this;
//        }
//
//        public Builder dayId(Long integer) {
//            this.dayId = integer;
//            return this;
//        }
//
//        public Builder dateTime(LocalDateTime dateTime) {
//            this.dateTime = dateTime;
//            return this;
//        }
//
//        public Builder billTotal(Integer billTotal) {
//            this.billTotal = billTotal;
//            return this;
//        }
//
//        public Builder billPayed(Integer billPayed) {
//            this.billPayed = billPayed;
//            return this;
//        }
//
//        public Builder billRemained(Integer billRemained) {
//            this.billRemained = billRemained;
//            return this;
//        }
//
//        public Builder customerId(Long customerId) {
//            this.customerId = customerId;
//            return this;
//        }
//
//        public Builder customerName(String customerName) {
//            this.customerName = customerName;
//            return this;
//        }
//
//        public Builder billTypeId(Integer billTypeId) {
//            this.billTypeId = billTypeId;
//            return this;
//        }
//
//        public billDTO build() {
//            return new billDTO(this);
//        }
//    }
//
//    
    
    
    public boolean isReturnedBill() {
		return returnedBill;
	}

	public Integer getBillDayCounter() {
		return billDayCounter;
	}

	public void setBillDayCounter(Integer billDayCounter) {
		this.billDayCounter = billDayCounter;
	}

	public void setReturnedBill(boolean returnedBill) {
		this.returnedBill = returnedBill;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setBillTypeId(Integer billTypeId) {
		this.billTypeId = billTypeId;
	}

	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
	}

	public void setBillProductModelList(List<billProductDTO> billProductModelList) {
		this.billProductModelList = billProductModelList;
	}
    
	public String getBillTypeName()
    {
    	return billTypeName;
    }
    public List<billProductDTO> getBillProductModelList() {
		return billProductModelList;
	}

	public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getDayId() {
        return dayId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(Double billTotal) {
		this.billTotal = billTotal;
	}

	public Double getBillPayed() {
		return billPayed;
	}

	public void setBillPayed(Double billPayed) {
		this.billPayed = billPayed;
	}

	public Double getBillRemained() {
		return billRemained;
	}

	public void setBillRemained(Double billRemained) {
		this.billRemained = billRemained;
	}

	public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getBillTypeId() {
        return billTypeId;
    }
}
