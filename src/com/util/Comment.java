package com.util;

public class Comment {
    private Integer id;
    
    private String username; 
    
    private Integer userid;

    private String comments;

    private String categoryid;

    private String display;

    private Integer newid;

    private String commenttime;

    private Integer praisecount;

    private Integer stepcount;

    private String remark;

    private Integer ischeck;

    private Integer checknum;

    private String rootId;
    
    private String sourceType;
    
    
    public String getSourceType() {
	
		return sourceType;
	}

	public void setSourceType(String sourceType) {
	
		this.sourceType = sourceType;
	}

	public String getRootId() {
	
		return rootId;
	}

	public void setRootId(String rootId) {
	
		this.rootId = rootId;
	}

	public String getUsername() {
	
		return username;
	}

	public void setUsername(String username) {
	
		this.username = username;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display == null ? null : display.trim();
    }

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime == null ? null : commenttime.trim();
    }

    public Integer getPraisecount() {
        return praisecount;
    }

    public void setPraisecount(Integer praisecount) {
        this.praisecount = praisecount;
    }

    public Integer getStepcount() {
        return stepcount;
    }

    public void setStepcount(Integer stepcount) {
        this.stepcount = stepcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIscheck() {
        return ischeck;
    }

    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    public Integer getChecknum() {
        return checknum;
    }

    public void setChecknum(Integer checknum) {
        this.checknum = checknum;
    }
}