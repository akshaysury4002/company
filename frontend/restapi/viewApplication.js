const readIdQueryParam = () => {
    const params = new Proxy(new URLSearchParams(window.location.search), {
        get: (searchParams, prop) => searchParams.get(prop),
    });
    return params.roleId
}


console.log(readIdQueryParam())


function setupTable() {
    const table = document.getElementById('tableApplication')

    apiFetchAllBookings(table)
}

setupTable()

function propulateActualData(table, bd) {

    console.log(bd)
    for(const role of bd) {

       

       


        const row = table.insertRow()
       
    }
}



function propulateActualData(table, roles) {

    for(const role of roles) {

       

        const {id, name,email,contactNo,totalExp,currentCtc,expectedCtc,skills} = role

        console.log(role)

        const row = table.insertRow()
        row.insertCell(0).innerHTML = id
        row.insertCell(1).innerHTML = name
        row.insertCell(2).innerHTML = email
        row.insertCell(3).innerHTML = contactNo
        row.insertCell(4).innerHTML = totalExp
        row.insertCell(5).innerHTML = currentCtc
        row.insertCell(6).innerHTML = expectedCtc
        row.insertCell(7).innerHTML = skills
    }
}


function apiFetchAllBookings(table) {

    const roleId=readIdQueryParam()
    
    axios.get(`http://localhost:8080/company/getEmp/${roleId}`)
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            console.log(bd)
            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
    
        
}

