/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	
	/*config.toolbar = 'Full';   
	config.toolbar_Full = [ 
	    { name: 'document', items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },     
		{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] }, 
	    { name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },     
		{ name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton','HiddenField' ] },     '/', 
	    { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },     
		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },     
		{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },     
		{ name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe' ] },'/', 
	    { name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] }, 
		{ name: 'colors', items : [ 'TextColor','BGColor' ] }, 
	    { name: 'tools', items : [ 'Maximize', 'ShowBlocks','-','About' ] } 
	]; */
	
	config.toolbar='MyToolbar';
	config.toolbar_MyToolbar = [     
					            ['Link'],['Image'] ,['Table']   
	];
	
	
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config
	config.uiColor = '#C9DFF7';
	// The toolbar groups arrangement, optimized for two toolbar rows.
	/*config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' }
	];*/

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
	
	config.filebrowserUploadUrl="actions/ckeditorUpload";
	
//	config.skin = 'v2';//界面v2,kama,office2003  

	var pathName = window.document.location.pathname;
	//获取带"/"的项目名，如：/uimcardprj
//	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	var projectName = getContextPath();
	

	
	config.filebrowserImageUploadUrl = projectName + '/uploader/uploader.do?type=image'; //图片上传路径
	config.image_previewText = ' '; // 去掉图片预览中的鸟语，这里注意里面一定要有个空格  
	config.filebrowserUploadUrl=projectName + '/uploader/uploader.do?type=file'; //文件上传路径
	
};
