// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();

  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
  document.getElementById("txtEmailUsuario").outerHTML = localStorage.email;
}

async function cargarUsuarios() {

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeaders()
  });
  const usuarios = await request.json();

  let listadoHtml = '';

  for (let usuario of usuarios) {

    let btnEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btclassNamecle"><i class="fas fa-trash"></i></a>'
    usuario.telefono = usuario.telefono ? usuario.telefono : '-';

    let usuarioHtml = '<tr><td>' + usuario.id + '</td>' +
        '<td>' + usuario.nombre + ', ' + usuario.apellido + '</td>' +
        '<td>' + usuario.email + '</td>' +
        '<td>' + usuario.telefono + '</td>' +
        '<td>' + btnEliminar + '</td></tr>'

    listadoHtml += usuarioHtml;
  }
  document.querySelector("#usuarios tbody").outerHTML = listadoHtml;

  console.log(usuarios);

}

function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}

async function eliminarUsuario (id) {

  if (!confirm("¿Desea eliminar el usuario?")) {
    return;
  }

  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  document.location.reload();
}