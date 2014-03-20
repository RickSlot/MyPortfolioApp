var collaborators = 0;


function addCollaborator(){
    $('#collaborators-field').append("<p><strong>New Collaborator:</strong></p><input id='collaborator' class='form-control' name='collaboratorUsernames["+ collaborators +"]' type='text'><br>");
    collaborators++;
}

function setCollaboratorsSize(size){
    collaborators = size;
}

function removeCollaborator(id){
    $('#collaborator' + id).remove();
    $('#removeButton' + id).remove();
}
