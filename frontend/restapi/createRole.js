const readIdQueryParam = () => {
    const params = new Proxy(new URLSearchParams(window.location.search), {
        get: (searchParams, prop) => searchParams.get(prop),
    });
    return params.deptId
}


console.log(readIdQueryParam())

const validateForm = ({ roleName }) => {

    if (roleName.length <= 0) return { msg: 'Comment cannot be empty', sts: false}
 
    return { sts : true , msg :'all fields are valid' }
}

function setupForm() {

    const err = document.getElementById('errMsg')
    err.style.display = 'none'
    
    const createrole = document.getElementById('formCApplication')

    createrole.onsubmit = ev => { 

        ev.preventDefault() 

        const formData = new FormData(ev.target) 

        const user = Object.fromEntries(formData.entries()) 
        console.log(user)

        // apiFeedback(user, feedback)

        const { sts, msg } = validateForm(user)

        if (sts) apicreaterole(user, createrole)
        else {
            err.style.display = 'block'
            err.innerHTML = `<strong>${msg}</strong>`
        }
    }
}

setupForm()

function apicreaterole(user, form) {
    const headers = {
        'content-type': 'application/json'
    }

    const deptId=readIdQueryParam()
    
    const url = `http://localhost:8080/company/${deptId}/role`
    axios.post(url , user, { headers })
        .then(()=> {
            form.reset()
            showSuccessModal()

        }).catch(err => console.log(err))
}

function showSuccessModal() {
    const myModalEl = document.getElementById('successModal');
    const modal = new bootstrap.Modal(myModalEl)
    modal.show()
}


