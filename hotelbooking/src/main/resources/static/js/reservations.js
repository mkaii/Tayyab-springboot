window.addEventListener('load', function () {
    const deleteButtons = document.querySelectorAll('.delete-reservation-button');
    deleteButtons.forEach(deleteButton => {
        const reservationId = deleteButton.getAttribute('data-reservation-id');
        deleteButton.addEventListener('click', function () {
            this.disabled = true; // Disable the button to prevent multiple clicks
            fetch(`/api/reservations/${reservationId}`, {method: 'DELETE'})
                .then(response => {
                    if (response.status === 204) {
                        document.querySelector(`#reservation-${reservationId}`).remove();
                    }

                });
        });
    });
});
