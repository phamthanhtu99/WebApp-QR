
function validator(formselector) {
    var $ = document.querySelector.bind(document)
var $$ = document.querySelectorAll.bind(document)
    var _this=this
    var formRules = {}
    var validatorRules = {
        required: function (value) {
            return value ? undefined : 'Vui long nhập trường  '
        },
        email: function (value) {
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            return regex.test(value) ? undefined : 'vui lòng nhập lại email'
        },
        min: function (min) {
            return function (value) {
                return value.length >= min ? undefined : `Vui lòng nhập tối thiểu ${min}`
            }
        },
    
    }

    var formElement = $(formselector)


    if (formElement) {
        var inputs = formElement.querySelectorAll('[name][rules]')//lấy tất cả các input có rules và name
        for (var input of inputs) { //lọc quan các phần tử inputs
            var rule=input.getAttribute('rules');
            var ruleFunc =  validatorRules[rule];
            if (Array.isArray(formRules[input.name])) {
                formRules[input.name].push(ruleFunc)
            } else {
                formRules[input.name] = [ruleFunc]
            }
               
            input.onblur = handleValidate;
        }
          
        //xử lý hành vi onblur
        function handleValidate(event) {
            var rules = formRules[event.target.name]
            var errorMessage;
            for (rule of rules) {
                errorMessage = rule(event.target.value)
                if (errorMessage) {
                    break;
                }
            };
            var inputGroud = getParent(event.target, '.form-group'); //lấy ra thẻ div cha cua input
            var formMessge =  inputGroud.querySelector('.form-message')
            if (errorMessage) {
                if (inputGroud) {
                    inputGroud.classList.add('invalid')

                    formMessge.innerHTML = errorMessage;

                }

            } else {
                formMessge.innerHTML = '';
                inputGroud.classList.remove('invalid')
            }

            return !errorMessage;
        }

        //xử lý hành vi oninput
        
        //xử lí hành vi submit
        formElement.onsubmit = function (e) {
            e.preventDefault();
            var isvalid = true;
            var inputs = formElement.querySelectorAll('[name][rules]')//lấy tất cả các input có rules và name
            for (var input of inputs) { //lọc điều kiện có 2 rules trở lên
                if (!handleValidate({ target: input })) {
                    isvalid = false;
                }
            }

            if (isvalid) {

                if (typeof _this.onSubmit === 'function') {
                    var inputvalue = formElement.querySelectorAll('[name]')
                    var formValues = Array.from(inputvalue).reduce(function (values, input) {

                        switch (input.type) {
                            case 'radio':
                                if (input.matches(':checked')) {
                                    values[input.name] = input.value;
                                } break
                            case 'checkbox':
                                if (!input.matches(':checked')) return values
                                if (!Array.isArray(values[input.name])) {
                                    values[input.name] = []
                                }
                                values[input.name].push(input.value)

                                break;
                            case 'file':
                                values[input.name] = input.files
                                break
                            default:{
                                if(input.name==="price"){
                                    var total = parseFloat(input.value.toString().replace(/,/g, '')) ;
                                    values[input.name] =total;

                                }else{
                                    values[input.name] = input.value
                                }

                            }
                        }

                        return values
                    }, {})
                    return _this.onSubmit(formValues);
                }
                formElement.submit();
            }
        }
        function getParent(element, selecttor) {
            while (element.parentElement) {
                if (element.parentElement.matches(selecttor)) {
                    return element.parentElement;
                }
                element = element.parentElement;
            }
        }
        console.log(formRules);
    }
}