window.addEventListener('load', function () {
    const retrieveButton = document.querySelector('#show-assigned-guests');
    if (retrieveButton) {
        const roomId = retrieveButton.getAttribute('data-room-id');
        const reservedGuestContainer = document.querySelector('#assigned-guests');
        retrieveButton.addEventListener('click', function() {
            fetch(`/api/rooms/${roomId}/reserved`)
                .then(response => response.json())
                .then(guests => {
                    let html = '<ul>';
                    if (guests.length === 0) {
                        html += '<li><i>There are no Guests!</i></li>';
                    } else {
                        guests.forEach(guest => {
                            html += `<li>${guest.guestLastName}</li>`;
                        });
                    }
                    html += '</ul>';
                    reservedGuestContainer.innerHTML = html;
                })
                .catch(error => {
                    console.error('Error fetching reserved guests:', error);
                    reservedGuestContainer.innerHTML = '<p>Error fetching reserved guests</p>';
                });
        });
    }
});
