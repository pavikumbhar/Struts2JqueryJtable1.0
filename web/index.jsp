<html>
<head>
<title>jTable in Struts 2</title>
<!-- jTable metro styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />

<!-- jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
    
    
    $(document).ready(function() {
	$('#StudentTableContainer').jtable({
		title : 'Students List',
                 paging: true, //Enable paging
                 pageSize: 5, //Set page size (default: 10)
                // sorting: true, //Enable sorting
                toolbar: {
                            items: [{
                                icon: '/images/excel.png',
                                text: 'Export to Excel',
                                click: function () {
                                    //perform your custom job...
                                }
                            }]
                        },

		actions : {
			listAction : 'listAction',
			createAction : 'createAction',
			updateAction : 'updateAction',
			deleteAction : 'deleteAction'
		},

		fields : {
			studentId : {
				title : 'Student Id',
				width : '30%',
				key : true,
				list : true,
				edit : false,
				create : false
			},
			name : {
				title : 'Name',
				width : '30%',
				edit : true
			},
			department : {
				title : 'Department',
				width : '30%',
				edit : true
			},
			emailId : {
				title : 'Email',
				width : '20%',
				edit : true
			}
		}
	});
	 //Re-load records when user click 'load records' button.
        $('#LoadRecordsButton').click(function (e) {
            e.preventDefault();
            $('#StudentTableContainer').jtable('load', {
                name: $('#name').val()
            });
            //$('#name').val("");
        });
 
        //Load all records when page is first shown
        $('#LoadRecordsButton').click();
});
</script>

</head>
<body>
    
</div>
    <form>
	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h3>AJAX based CRUD operation in Struts 2 using jTable plugin</h3>
                 Search by S  Name: <input type="text" name="name" id="name" />
                 <button type="submit" id="LoadRecordsButton">Load records</button><br><br>
		<div id="StudentTableContainer"></div>
	</div>
    </form>
</body>
</html>