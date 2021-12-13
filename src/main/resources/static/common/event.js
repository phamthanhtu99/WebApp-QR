function run() {
    moneyFormat();
    loadImge();
    Imges();
    modal();
    moneyFormat();
}

run();
function moneyFormat() {
    var number = $('.price');
    number.keyup(function () {
        if (!number.val()) {
            return
        }
        var total = parseFloat(number.val().toString().replace(/,/g, ''));
        number.val(parseInt(total).toLocaleString());
    })
}
function loadImge() {
    var butom = $('.avata')
    var images = $('.images')
    var arquivo = $('.arquivo')
    arquivo.on('click', function () {
        butom.click()

    })
    butom.on('change', function (e) {
        getImgData();
        console.log("ok");
    })
    function getImgData() {
        var reader = new FileReader()
        reader.onload = function (event) {
            images.html('<div class="img_upload" style="background-image: url(\'' + event.target.result + '\');" rel="' + event.target.result + '"></div>')
            images.addClass("c")
        }
        reader.readAsDataURL(butom[0].files[0])

       
    }
}
function Imges() {
    var butom = $('.imgs_p')
    var images = $('.images_p')
    var a = $('.imgep')
    a.on('click', function () {
        butom.click()
    })
    butom.on('change', function () {
        for (var i = 0; i < $(this).get(0).files.length; ++i) {
            var reader = new FileReader()
            reader.onload = function (event) {
                images.prepend('<div class="img" style="background-image: url(\'' + event.target.result + '\');" rel="' + event.target.result + '"></div>')

            }
            reader.readAsDataURL(butom[0].files[i])
        }
    })
   
}

function modal(){
    var close= $('.close')
    var btn =$('#form_prudct');
    var modal= $('#myModal')
    btn.on('click',function(){
        modal.css("display","block")
        modal.load('/Show/form_add',function (resutls){
            modal.html(resutls)
        })
    })
    close.on('click',function(){
        modal.css("display","none")
    })
}
function moneyFormat(){
    var number= $('.price');
    number.keyup(function(){
        if(!number.val()){
            return
        }
        var total = parseFloat(number.val().toString().replace(/,/g, '')) ;
        number.val(parseInt(total).toLocaleString());
    })
}

