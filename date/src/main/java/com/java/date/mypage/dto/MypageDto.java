package com.java.date.mypage.dto;

public class MypageDto {
     
      private int point_code;
      private String id;
      private String point_manage;
      private int point_total;
      private String point_content;
      private String date;
      private String point_date;
      
      
      public String getDate() {
      return date;
      }
      public void setDate(String date) {
      this.date = date;
      }
      public String getPoint_date() {
      return point_date;
      }
      public void setPoint_date(String point_date) {
      this.point_date = point_date;
      }
   
      
      public int getPoint_code() {
         return point_code;
      }
      public void setPoint_code(int point_code) {
         this.point_code = point_code;
      }
      public String getId() {
         return id;
      }
      public void setId(String id) {
         this.id = id;
      }
      public String getPoint_manage() {
         return point_manage;
      }
      public void setPoint_manage(String point_manage) {
         this.point_manage = point_manage;
      }
      public int getPoint_total() {
         return point_total;
      }
      public void setPoint_total(int point_total) {
         this.point_total = point_total;
      }
      public String getPoint_content() {
         return point_content;
      }
      public void setPoint_content(String point_content) {
         this.point_content = point_content;
      }
}