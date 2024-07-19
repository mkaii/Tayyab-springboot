window.addEventListener('load', function () {
    const retrieveButton = document.querySelector('#show-reserved-rooms');
    if (retrieveButton) {
        const guestId = retrieveButton.getAttribute('data-guest-id');
        const reservedRoomsContainer = document.querySelector('#reserved-rooms');
        retrieveButton.addEventListener('click', function() {
            fetch(`/guests/${guestId}/reserved`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(rooms => {
                    let html = '<ul>';
                    if (rooms.length === 0) {
                        html += '<li><i>No reserved rooms!</i></li>';
                    } else {
                        rooms.forEach(room => {
                            html += `<li>${room.roomNumber}</li>`;
                        });
                    }
                    html += '</ul>';
                    reservedRoomsContainer.innerHTML = html;
                })
                .catch(error => {
                    reservedRoomsContainer.innerHTML = `<p>Error: ${error.message}</p>`;
                });
        });
    }
});
