// This file contains the JavaScript for handling the sidebar's dropdown functionality.

/**
 * Toggles the visibility of a dropdown menu and rotates its arrow.
 * It also closes any other open dropdowns.
 * @param {string} dropdownId The ID of the dropdown menu to toggle.
 */
function toggleDropdown(dropdownId) {
    const dropdown = document.getElementById(dropdownId);
    const arrow = document.getElementById(dropdownId.replace('-dropdown', '-arrow'));
    
    // Check if the dropdown and arrow elements exist
    if (!dropdown || !arrow) {
        console.error('Dropdown or arrow not found:', dropdownId, arrowId);
        return;
    }

    // Close all other dropdowns and reset their arrows
    const allDropdowns = document.querySelectorAll('.dropdown-menu');
    const allArrows = document.querySelectorAll('.dropdown-arrow');
    
    allDropdowns.forEach(menu => {
        if (menu.id !== dropdownId) {
            menu.classList.remove('open');
        }
    });
    
    allArrows.forEach(arrowEl => {
        if (arrowEl.id !== arrow.id) {
            arrowEl.classList.remove('rotate');
        }
    });
    
    // Toggle the current dropdown and its arrow
    dropdown.classList.toggle('open');
    arrow.classList.toggle('rotate');
}

// Add event listeners after the document has fully loaded
document.addEventListener('DOMContentLoaded', () => {
    // Close dropdowns when clicking outside
    document.addEventListener('click', function(event) {
        if (!event.target.closest('.dropdown-container')) {
            const allDropdowns = document.querySelectorAll('.dropdown-menu');
            const allArrows = document.querySelectorAll('.dropdown-arrow');
            
            allDropdowns.forEach(menu => menu.classList.remove('open'));
            allArrows.forEach(arrow => arrow.classList.remove('rotate'));
        }
    });

    // Prevent dropdown from closing when clicking inside it
    document.querySelectorAll('.dropdown-menu').forEach(menu => {
        menu.addEventListener('click', function(event) {
            event.stopPropagation();
        });
    });
});
