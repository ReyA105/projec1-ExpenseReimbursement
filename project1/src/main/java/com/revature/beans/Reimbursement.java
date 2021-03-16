package com.revature.beans;

import java.sql.Timestamp;

public class Reimbursement {
	private Integer reimbId;
	private Double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private String receipt;
	private Integer authorId;
	private Integer resolverid;
	private Integer statusid;
	private Integer typeId;
	
	public Integer getReimbId() {
		return reimbId;
	}
	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public Integer getResolverid() {
		return resolverid;
	}
	
	public void setResolverid(Integer resolverid) {
		this.resolverid = resolverid;
	}
	
	public Integer getStatusid() {
		return statusid;
	}
	
	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId
				+ ", resolverid=" + resolverid + ", statusid=" + statusid + ", typeId=" + typeId + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		
		if(reimbId == null) {
			if(other.reimbId != null)
				return false;
		}else if(!reimbId.equals(other.reimbId))
			return false;
		if(amount == null) {
			if(other.amount != null)
				return false;
		}else if(!amount.equals(other.amount))
			return false;
		if(submitted == null) {
			if(other.submitted != null)
				return false;
		}else if(!submitted.equals(other.submitted))
			return false;
		if(resolved == null) {
			if(other.resolved != null)
				return false;
		}else if(!resolved.equals(other.resolved))
			return false;
		if(description == null) {
			if(other.description != null)
				return false;
		}else if(!description.equals(other.description))
			return false;
		if(receipt == null) {
			if(other.receipt != null)
				return false;
		}else if(!receipt.equals(other.receipt))
			return false;
		if(authorId == null) {
			if(other.authorId != null)
				return false;
		}else if(!authorId.equals(other.authorId))
			return false;
		if(resolverid == null) {
			if(other.resolverid != null)
				return false;
		}else if(!resolverid.equals(other.resolverid))
			return false;
		if(statusid == null) {
			if(other.statusid != null)
				return false;
		}else if(!statusid.equals(other.statusid))
			return false;
		if(typeId == null) {
			if(other.typeId != null)
				return false;
		}else if(!typeId.equals(other.typeId))
			return false;
		
		
		
		
		return true;
		
	}
	
	
	
	
}
