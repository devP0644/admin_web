(function ($) {

    var maxBtnSize = 7;              // 검색 하단 최대 범위
    var indexBtn = [];               // 인덱스 버튼

    // 페이징 처리 데이터

    var total_pages = 0;          // 전체 페이지수
    var total_elements = 0;         // 전체 데이터수
    var current_page =  0;          // 현재 페이지수
    var current_elements = 0;


    // 페이지 정보
    var showPage = new Vue({
        el : '#showPage',
        data : {
            totalElements : {},
            currentPage:{}
        }
    });

    // 데이터 리스트
    var itemList = new Vue({
        el : '#itemList',
        data : {
            itemList : {}
        }
    });


    // 페이지 버튼 리스트
    var pageBtnList = new Vue({
        el : '#pageBtn',
        data : {
            btnList : {}
        },
        methods: {
            indexClick: function (id) {
                searchStart(id-1)
            },
            previousClick:function () {
                if(current_page !== 0){
                    searchStart(current_page-1);
                }
            },
            nextClick:function () {

                if(current_page !== total_pages-1){
                    searchStart(current_page+1);
                }
            }
        },
        mounted:function () {
            // 제일 처음 랜더링 후 색상 처리
            setTimeout(function () {
                $('li[btn_id]').removeClass( "active" );
                $('li[btn_id='+(current_page+1)+']').addClass( "active" );
            },50)
        }
    });


    $('#search').click(function () {
        searchStart(0)
    });

    $(document).ready(function () {
        searchStart(0)
    });
    
    function searchStart(index) {
        console.log("call index : "+index);
        $.get("/api/user?page="+index, function (response) {

            /* 데이터 셋팅 */
            // 페이징 처리 데이터
            indexBtn = [];
            pagination = response.pagination;


            //전체 페이지
            showPage.totalElements = current_elements;
            showPage.currentPage = current_page+1;


            // 검색 데이터
            itemList.itemList = response.data;


            // 이전버튼
            if(current_page === 0){
                $('#previousBtn').addClass("disabled")
            }else{
                $('#previousBtn').removeClass("disabled")
            }


            // 다음버튼
            if(current_page === total_pages-1){
                $('#nextBtn').addClass("disabled")
            }else{
                $('#nextBtn').removeClass("disabled")
            }

            // 페이징 버튼 처리
            var temp = Math.floor(current_page / maxBtnSize);
            for(var i = 1; i <= maxBtnSize; i++){
                var value = i+(temp*maxBtnSize);

                if(value <= total_pages){
                    indexBtn.push(value)
                }
            }

            // 페이지 버튼 셋팅
            pageBtnList.btnList = indexBtn;


            // 색상처리
            setTimeout(function () {
                $('li[btn_id]').removeClass( "active" );
                $('li[btn_id='+(current_page+1)+']').addClass( "active" );
            },50)
        });
    }

})(jQuery);