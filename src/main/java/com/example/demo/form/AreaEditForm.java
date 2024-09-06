package com.example.demo.form;

import lombok.Data;

@Data
public class AreaEditForm {
	
	//@NotNull(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	private int num;
	
	//@NotEmpty(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	//@Size(min=1, max=20, message="1~20文字で入力してください")
	private String name; 
	
	//@NotEmpty(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	//@Size(min=1, max=20, message="1~20文字で入力してください")
	private String dispName;

}
